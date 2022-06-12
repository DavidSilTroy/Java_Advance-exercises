package it.factory.lambdasearching.controller;

import it.factory.lambdasearching.model.School;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private School school = new School();

    @RequestMapping("/")
    public String Index(){
        return  "index";
    }
}
