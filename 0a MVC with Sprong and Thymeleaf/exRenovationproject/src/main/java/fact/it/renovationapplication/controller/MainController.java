package fact.it.renovationapplication.controller;

import fact.it.renovationapplication.model.Renovationproject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private Renovationproject paint;

    @RequestMapping("/")
    public	String	index()
    {
        return	"index";
    }

    @RequestMapping("/submitcalculate")
    public	String	calculatePaint(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        double length = Double.parseDouble(request.getParameter("lmeters"));
        double width = Double.parseDouble(request.getParameter("wmeters"));
        double heigth = Double.parseDouble(request.getParameter("hmeters"));

        paint = new Renovationproject(length,width,heigth);
        if (request.getParameter("ceiling") != null)
        {
            paint.setCeilingIncluded(true);
        }
        else
        {
            paint.setCeilingIncluded(false);
        }

        paint.setNumberOfLayers(Integer.parseInt(request.getParameter("layer")));

        model.addAttribute("clientName", name);
        model.addAttribute("paintLiters", paint.getAmountOfPaintInLitres());


        return	"calculation";
    }

}
