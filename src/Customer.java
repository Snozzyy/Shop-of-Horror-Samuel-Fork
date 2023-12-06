public class Customer {
    private double totalCost;
    private int unitsBought;

    public Customer(){
        /*When a customer starts the session cost and bought units should be zero*/
        totalCost = 0;
        unitsBought = 0;
    }

    public void addToTotalCost(double totalCost) {
        this.totalCost += totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
