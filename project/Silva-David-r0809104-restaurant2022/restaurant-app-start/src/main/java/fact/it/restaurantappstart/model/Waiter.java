package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Waiter extends Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Waiter() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void update(int number) {
        super.update(number);
        System.out.println("I am " + (getName()) + " and I start preparing the table for "  + (number) + " customers.");
    }
}
