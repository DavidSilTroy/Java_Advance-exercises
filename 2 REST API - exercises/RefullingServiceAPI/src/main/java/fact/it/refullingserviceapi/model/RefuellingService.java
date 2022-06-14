package fact.it.refullingserviceapi.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {
    private List<Refuelling> refuellingList = new ArrayList<>();

    public RefuellingService(){
        refuellingList.add( new Refuelling(1,0,300,12.9));
        refuellingList.add( new Refuelling(2,300,900,22.5));
        refuellingList.add( new Refuelling(3,900,1099,9.45));
        refuellingList.add( new Refuelling(4,1099,2002,43.28));
        refuellingList.add( new Refuelling(5,2002,2413,19.99));

    }

    public Optional<Refuelling> getOptionalRefuellingById(int id){
        return getRefullingList().stream().filter(r -> r.getId() == id).findFirst();
    }

    public List<Refuelling> getRefullingList() {
        return refuellingList;
    }

    public void setRefullingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefuelling( Refuelling newRefulling){
        newRefulling.setId(refuellingList.size()+1);
        refuellingList.add(newRefulling);
        return refuellingList.get(refuellingList.size()-1);

    }
    public Refuelling updateRefuellingById(Refuelling updateRefulling, int refuelingId){
        Optional<Refuelling> refuellingOptional = getOptionalRefuellingById(refuelingId);
        if (refuellingOptional.isPresent()){
            Refuelling refuelling = refuellingOptional.get();
            refuelling.setAmountInLitres(updateRefulling.getAmountInLitres());
            refuelling.setCurrentMileage(updateRefulling.getCurrentMileage());
            refuelling.setPreviousMileage(updateRefulling.getPreviousMileage());
            return refuelling;
        }
        return null;
    }
    public double getTotalCompsumption(){
        return refuellingList.stream().mapToDouble(Refuelling::getFuelConsumption).sum();
    }


}
