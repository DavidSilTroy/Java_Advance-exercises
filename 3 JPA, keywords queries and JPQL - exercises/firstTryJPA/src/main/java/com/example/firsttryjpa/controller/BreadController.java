package com.example.firsttryjpa.controller;

import com.example.firsttryjpa.model.Bread;
import com.example.firsttryjpa.repository.BreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BreadController {
    private BreadRepository breadRepository;
    public BreadController(BreadRepository breadRepository){
        this.breadRepository = breadRepository;
    }
    @PostConstruct
    public void fillDatabaseTemporary(){
        for (int i = 0; i<10; i++){
            Bread bread = new Bread();
            bread.setName("Bread"+i);
            bread.setPrice(25.5-i);
            breadRepository.save(bread);
        }
    }

    @RequestMapping("/")
    public String index (Model model){
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breadList", list);
        return "index";
    }
    @RequestMapping("/search")
    public String search (Model model, HttpServletRequest request){
        String searchString = request.getParameter("searchstring");
        searchString = searchString != null? searchString : "";
        List<Bread> list = breadRepository.findAllByNameStartsWith(searchString);
        model.addAttribute("breadList", list);
        model.addAttribute("searchedString",searchString);
        return "index";
    }
    @RequestMapping("/searchcheap")
    public String searchcheap (Model model, HttpServletRequest request){
        String searchString = request.getParameter("searchstring");
        searchString = searchString != null? searchString : "";
        List<Bread> list = breadRepository.findCheapestBreads();
        model.addAttribute("breadList", list);
        model.addAttribute("searchedString",searchString);
        return "index";
    }
    @RequestMapping("/add")
    public String add (){
        return "add";
    }

    @RequestMapping("/processadd")
    public String processAdd(Model model, HttpServletRequest request){
        String breadName = request.getParameter("name");
        Double breadPrice = Double.parseDouble(request.getParameter("price"));
        Bread bread = new Bread();
        bread.setName(breadName);
        bread.setPrice(breadPrice);
        breadRepository.save(bread);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breadList", list);
        return "index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        // breadRepository.findById(breadId) returns an Optional, a value that can also be null. By using the .get()-method we can retrieve the actual value.
        Bread bread = breadRepository.findById(breadId).get();
        model.addAttribute("bread", bread);
        return "edit";
    }
    @RequestMapping("/processedit")
        public String processEdit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        String breadName = request.getParameter("name");
        Double breadPrice = Double.parseDouble(request.getParameter("price"));
        Bread bread = breadRepository.findById(breadId).get();
        bread.setName(breadName);
        bread.setPrice(breadPrice);
        breadRepository.save(bread);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breadList",list);
        return "index";
    }
    @RequestMapping("/delete")
        public String delete(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        breadRepository.deleteById(breadId);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breadList",list);
        return "index";
    }
}

