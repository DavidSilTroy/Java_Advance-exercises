package fact.it.restaurantappstart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class EntranceCounter extends Subject{
    int number;
    private static EntranceCounter entranceCounter;


    private EntranceCounter() {
    }
    public static EntranceCounter getInstance(){
        if (entranceCounter == null){
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        this.notifyObserver();
    }

    @Override
    public void attachObserver(Staff observer) {
        System.out.println("added new Observer");
        this.getObservers().add(observer);

    }

    @Override
    public void detachObserver(Staff observer) {
        int observerIndex = this.getObservers().indexOf(observer);
//        System.out.println("Observer " + (observerIndex+1) + " deleted");
        this.getObservers().remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Staff observer : this.getObservers()){
            observer.update(number);
        }
    }

}
