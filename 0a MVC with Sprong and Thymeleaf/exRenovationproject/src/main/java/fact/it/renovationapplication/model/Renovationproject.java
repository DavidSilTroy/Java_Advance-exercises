package fact.it.renovationapplication.model;

public class Renovationproject
{
    private double length;
    private double width;
    private double heigth;
    private int numberOfLayers;
    private boolean ceilingIncluded;

    public Renovationproject(double length,double width,double heigth){
        this.heigth = heigth;
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    public boolean isCeilingIncluded() {
        return ceilingIncluded;
    }

    public void setCeilingIncluded(boolean ceilingIncluded) {
        this.ceilingIncluded = ceilingIncluded;
    }

    public double getAmountOfPaintInLitres(){
        double total =2*(length+width)*heigth;
        if (ceilingIncluded)
        {
            total = total + (length*width);
        }
        return  total * numberOfLayers / 10;
    }
}
