package it.factory.lambdasearching.controller;

import it.factory.lambdasearching.model.School;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class MainController {
    private School school = new School();

    @RequestMapping("/")
    public String Index(HttpServletRequest request, Model model){
        String firstName = (request.getParameter("firstname") != null ? request.getParameter("firstname") : "");
        String lastName = (request.getParameter("lastname") != null ? request.getParameter("lastname") : "");
        String courseName = (request.getParameter("course") != null ? request.getParameter("course") : "");
        String age = (request.getParameter("age") != null ? request.getParameter("age") : "");
        String coursesNumber = (request.getParameter("coursesnumber") != null ? request.getParameter("coursesnumber") : "");

        HashMap<String,Object> schoolMap = new HashMap<>();
        schoolMap.put("courses", school.getCourseList());
        schoolMap.put("firstName", firstName);
        schoolMap.put("lastName", lastName);
        schoolMap.put("courseName", courseName);
        schoolMap.put("age", age);
        schoolMap.put("coursesNumber", coursesNumber);

        if (request.getParameter("submit") == null){
            schoolMap.put("result", "");
        }
        else{

            schoolMap.put("result", "List of Students:");
            schoolMap.put("studentsList",
                    school.getFilteredList(
                            lastName,
                            firstName,
                            !Objects.equals(age, "") ? Integer.parseInt(age):0,
                            !Objects.equals(coursesNumber, "")? Integer.parseInt(coursesNumber):0,
                            courseName));
        }


        model.addAllAttributes(schoolMap);

        return  "index";
    }
}
