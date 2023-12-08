public class OnSaleMerchandise extends Merchandise {

    private final double discountPercentage;

    public OnSaleMerchandise(String productNameIn, double priceIn, int unitsLeftIn,double discountPercentageIn){
        super(productNameIn, priceIn, unitsLeftIn);
        discountPercentage = discountPercentageIn;
        discountedPrice();
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Calculates the discounted price
    private void discountedPrice() {
        price = price * (1 - discountPercentage);
    }
}
