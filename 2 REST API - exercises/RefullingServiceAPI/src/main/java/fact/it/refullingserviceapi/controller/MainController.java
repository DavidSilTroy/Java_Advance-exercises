package fact.it.refullingserviceapi.controller;

import fact.it.refullingserviceapi.model.Refuelling;
import fact.it.refullingserviceapi.model.RefuellingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private RefuellingService refuellingService;

    @PostConstruct
    public void fillRefuellingServiceWithData(){
        refuellingService = new RefuellingService();
    }
    @GetMapping("/")
    public String index(){
        return "Hello to the Refuelling API!";
    }
    @GetMapping("/refuellings/totalConsumption")
    public double getTotalConsumption(){
        return refuellingService.getTotalCompsumption();
    }
    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuelling(){
        return refuellingService.getRefullingList();
    }
    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getRefuellingById(@PathVariable("id") int refuellingId){
        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(refuellingId);
        if(refuelling.isPresent()){
            return new ResponseEntity<>(refuelling.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @PostMapping("/refuelling/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Refuelling addRefuelling( @RequestBody Refuelling newRefuelling){
        return refuellingService.addRefuelling(newRefuelling);
    }
    @PutMapping("/refuelling/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(@RequestBody Refuelling updateRefuelling,@PathVariable("id") int refuellingId){
        Refuelling refuelling = refuellingService.updateRefuellingById(updateRefuelling,refuellingId);
        if (refuelling == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(refuelling, HttpStatus.OK);
    }
    @DeleteMapping("/refuelling/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int refuellingId){
        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(refuellingId);
        if(refuelling.isPresent()){
            refuellingService.getRefullingList().remove(refuelling.get());
            return new ResponseEntity<>(refuellingService.getRefullingList().size(),HttpStatus.OK);
        }
        return new ResponseEntity<>(refuellingService.getRefullingList().size(),HttpStatus.NOT_FOUND);
    }
}
