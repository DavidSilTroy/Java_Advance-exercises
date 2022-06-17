package fact.it.restaurantappstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import fact.it.restaurantappstart.model.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {



    @RequestMapping("/start")
    public String starten(Model model, HttpServletRequest request) {
        String feedbacktekst ="";

        if (request.getParameter("singletontest") != null) {
            System.out.println("####################################################################");
            EntranceCounter it1 = EntranceCounter.getInstance();
            EntranceCounter it2;
            it2 = EntranceCounter.getInstance();
            if (it1 == it2) {
                System.out.println("The 2 singleton variables refer to the same object.");
            } else {
                System.out.println("The Singleton-pattern is not correct implemented");
            }
            System.out.println("####################################################################");
            feedbacktekst = "The singletontest has been executed. Check the output window of IntelliJ to see the result";

        }
        if (request.getParameter("observertest") != null) {
            EntranceCounter klantTeller = EntranceCounter.getInstance();

            //een paar personeelsleden
            Waiter jan = new Waiter();
            jan.setName("Jan");
            Waiter piet = new Waiter();
            piet.setName("Piet");
            KitchenStaff serge = new KitchenStaff();
            serge.setName("Serge");
            KitchenStaff jeroen = new KitchenStaff();
            jeroen.setName("Jeroen");

            //we koppelen de spelers en scheidsrechter als observer aan de bal
            klantTeller.attachObserver(jan);
            klantTeller.attachObserver(piet);
            klantTeller.attachObserver(serge);
            klantTeller.attachObserver(jeroen);


            System.out.println("####################################################################");
            System.out.println("After attaching the observers, 5 customers enter the restaurant (the number of entrance counter is set at 5)");
            //bal van positie veranderen
            klantTeller.setNumber(5);
            //lege lijn
            System.out.println();
            //we doen enkele observers weg
            klantTeller.detachObserver(piet);
            klantTeller.detachObserver(serge);

            System.out.println("After detaching Piet and Serge, 3 customers enter the restaurant (the number of the entrance counter is set tot 3)");
            //we veranderen de bal weer van positie
            klantTeller.setNumber(3);
            System.out.println("####################################################################");
            feedbacktekst = "The observer test has been executed. Check the output window of IntelliJ to see the result";

        }
        if (request.getParameter("strategytest") != null) {
//            System.out.println("####################################################################");
//            //Betalingstrategieën aanmaken
//            HappyHourPayment happyHourPayment = new HappyHourPayment();
//            NormalPayment normalPayment = new NormalPayment();
//            //gerechten aanmaken
//            Dish videe = new Dish();
//            videe.setName("Fish and Chips");
//            videe.setCurrentPrice(15.0);
//            Dish croque = new Dish();
//            croque.setName("Cottage Pie");
//            croque.setCurrentPrice(10.0);
//
//
//            //maak order met bestelitems
//            Order order = new Order();
//            //NORMAAL
//            order.setPaymentStrategy(normalPayment);
//            order.setDate(LocalDate.now());
//            order.addItem(videe, 2);
//            order.addItem(croque, 2);
//            System.out.println("The normal payment strategy is implemented: ");
//            for( OrderItem i: order.getBesteldItems()){
//                System.out.println(i.getQuantity() + " " + i.getDish().getName() + " price " + i.getAppliedPrice() );
//            }
//
//
//            //HAPPYHOUR
//            order.setPaymentStrategy(happyHourPayment);
//            order.addItem(videe, 2);
//            order.addItem(croque, 2);
//            System.out.println("The happy-hour payment strategy is implemented: ");
//            for (int i=2;i<4;i++){
//                System.out.println(order.getBesteldItems().get(i).getQuantity() + " " + order.getBesteldItems().get(i).getDish().getName() + " price " + order.getBesteldItems().get(i).getAppliedPrice() );
//            }
//
//            //NORMAAL
//            order.setPaymentStrategy(normalPayment);
//            order.addItem(videe, 2);
//            order.addItem(croque, 2);
//            System.out.println("The normal payment strategy is implemented again: ");
//            for (int i=4;i<6;i++){
//                System.out.println(order.getBesteldItems().get(i).getQuantity() + " " + order.getBesteldItems().get(i).getDish().getName() + " price " + order.getBesteldItems().get(i).getAppliedPrice() );
//            }
//            System.out.println("Order balance " + order.getTotal() + " euro");
//            System.out.println("####################################################################");
//            feedbacktekst = "strategytest has been executed. Check the output window of IntelliJ to see the result";
        }
        if (request.getParameter("decoratortest") != null) {
//            EntranceCounter entranceCounter = EntranceCounter.getInstance();
//            entranceCounter.getObservers().clear();
//            // een nieuw zaalpersoneelslid toevoegen
//            System.out.println("####################################################################");
//            Waiter manu = new Waiter("Manu");
//            entranceCounter.attachObserver(manu);
//            entranceCounter.setNumber(7);
//            // we gaan manu detachen en hem als poetspersoon attachen zodat hij nog altijd kan reageren op de klantenteller maar daarbij ook kan schoonmaken
//            System.out.println("####################################################################");
//            entranceCounter.detachObserver(manu);
//            entranceCounter.setNumber(10);
//            CleaningStaff poetsPersoon = new CleaningStaff();
//            poetsPersoon.setStaff(manu);
//            poetsPersoon.clean();
//            // Manu moet nu ook nog de administratie erbij nemen als iemand binnenkomt
//            System.out.println("####################################################################");
//            Administrator administrator = new Administrator();
//            administrator.setStaff(manu);
//            entranceCounter.attachObserver(administrator);
//            entranceCounter.setNumber(5);
//            System.out.println("####################################################################");
//            feedbacktekst = "decoratortest has been executed. Check the output window of IntelliJ to see the result";

        }
        model.addAttribute("tekst", feedbacktekst);
        return "index";
    }
}
