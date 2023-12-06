public class Merchandise {
    protected String productName;
    protected double price;
    protected int unitsLeft;
    /*We can use this to count up the number of certain products bought */
    protected int unitsCounter;
    public Merchandise(String productNameIn, double priceIn, int unitsLeftIn){
        productName = productNameIn;
        price = priceIn;
        unitsLeft = unitsLeftIn;
        unitsCounter = 0;
    }

    public double soldUnit(){
        if (unitsLeft > 0) {
            this.unitsCounter++;
            this.unitsLeft--;
            return this.price;
        } else {
            System.out.println("Varan finns ej i lager");
            return 0;
        }
    }

    public double getPrice() {
        return price;
    }

    public int getUnitsLeft() {
        return unitsLeft;
    }

    public String getProductName() {
        return productName;
    }

    public int getUnitsCounter() {
        return unitsCounter;
    }
}
