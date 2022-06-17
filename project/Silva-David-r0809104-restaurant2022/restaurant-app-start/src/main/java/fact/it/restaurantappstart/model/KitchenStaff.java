package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitchenStaff extends Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public KitchenStaff() {
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
        System.out.println("I am " + (getName()) + " and I start now with preparing "  + (number) + " appetizers!");
    }
}
