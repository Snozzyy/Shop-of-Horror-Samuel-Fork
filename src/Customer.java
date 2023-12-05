public class Customer {
    private double totalCost;
    private int unitsBought;

    public Customer(){
        /*When a customer starts the session cost and boughtunits should be zero*/
        totalCost = 0;
        unitsBought = 0;
    }

    public void addToTotalCost(double totalCost) {
        this.totalCost += totalCost;
    }

    public void setUnitsBought(int unitsBought) {
        this.unitsBought = unitsBought;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getUnitsBought() {
        return unitsBought;
    }
}
