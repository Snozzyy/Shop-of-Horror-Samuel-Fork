public class OnSaleMerchandise extends Merchandise {

    private double discountPercentage;

    public OnSaleMerchandise(String productNameIn, double priceIn, int unitsLeftIn,double discountPercentageIn){

        super(productNameIn, priceIn, unitsLeftIn);
        discountPercentage = discountPercentageIn;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public double soldUnit() {
        this.unitsCounter++;
        this.unitsLeft--;
        /*Returns the price with applied discount*/
        return this.getPrice();
    }

    @Override
    public double getPrice() {
        return super.getPrice()*(1- discountPercentage);
    }
}
