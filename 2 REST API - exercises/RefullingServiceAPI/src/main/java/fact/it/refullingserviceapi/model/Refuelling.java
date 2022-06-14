package fact.it.refullingserviceapi.model;

public class Refuelling {
    private int id;
    private int currentMileage;
    private int previousMileage;
    private double amountInLitres;

    public Refuelling(int id, int previousMileage, int currentMileage, double amountInLitres){
        this.id = id;
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLitres = amountInLitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }


    public double getFuelConsumption() {
        if (currentMileage<previousMileage){
            int tempCurrentMileage = currentMileage;
            currentMileage = previousMileage;
            previousMileage = tempCurrentMileage;
        }
        return 100*amountInLitres/(currentMileage-previousMileage);
    }
}
