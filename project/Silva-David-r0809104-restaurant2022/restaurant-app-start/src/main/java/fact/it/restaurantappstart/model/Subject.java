package fact.it.restaurantappstart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observer;

public abstract class Subject {
    private ArrayList<Staff> observers = new ArrayList<Staff>();
    public void attachObserver(Staff observer){

    };
    public void detachObserver(Staff observer){

    };
    public  void notifyObserver(){

    };


    public ArrayList<Staff> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Staff> observers) {
        this.observers = observers;
    }
}
