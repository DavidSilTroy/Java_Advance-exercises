package fact.it.coursedetail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@Controller
public class MainController {



    @RequestMapping("/")
    public	String	index()
    {
        return	"index";
    }

    @RequestMapping("/courseinfo")
    public	String	calculatePaint(HttpServletRequest request, Model model) throws ParseException {
        String coursename = request.getParameter("coursename");
        String location = (request.getParameter("location"));

        String ndays = (request.getParameter("ndays"));
        String info = "This course starts on ";

        SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date       = oldformat.parse (request.getParameter("startdate"));
        String startdate = newformat.format(date) ;


        if (request.getParameter("weekly") != null)
        {
            info = "this is a weekly course, starting on "  +startdate + " running for " + ndays + " weeks.";
        }
        else
        {
            info = info  + startdate + " and runs for " + ndays + " days.";
        }

        model.addAttribute("coursename", coursename);
        model.addAttribute("location", location);
        model.addAttribute("info", info);

        return "courseinfo";
    }

}
