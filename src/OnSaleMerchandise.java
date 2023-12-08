public class OnSaleMerchandise extends Merchandise {

    private final double discountPercentage;
    private double discountedPrice;

    public OnSaleMerchandise(String productName, double price, int unitsLeft, double discountPercentage) {
        super(productName, price, unitsLeft);
        this.discountPercentage = discountPercentage;
        discountedPrice();
    }

    public double soldUnit() {
        if (unitsLeft > 0) {
            unitsCounter++;
            unitsLeft--;
            return discountedPrice;
        } else {
            System.out.println("Varan finns ej i lager");
            return 0;
        }
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Calculates the discounted price
    private void discountedPrice() {
        discountedPrice = price * (1 - discountPercentage);
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
