package it.factory.lambdaprimecalculator.controller;

import it.factory.lambdaprimecalculator.model.PrimeCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private PrimeCalculator prime = new PrimeCalculator();
    List<Integer> numbersList = prime.getAllPrimeUntil(0);

    @RequestMapping("/")
    public String Calculate(HttpServletRequest request, Model model) {
        String strNumb = (request.getParameter("number") != null ? request.getParameter("number") : "0");
        int number = Integer.parseInt(strNumb);
        numbersList = prime.getAllPrimeUntil(number);
        model.addAttribute("numberList", numbersList);
        model.addAttribute("numberSelected", number);
        return "index";
    }
}
