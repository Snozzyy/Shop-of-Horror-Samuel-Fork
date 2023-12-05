public class OnSaleMerchandise extends Merchandise {

    private double discountpercentage;

    public OnSaleMerchandise(String productNameIn, double priceIn, int unitsLeftIn,double discountpercentageIn){

        super(productNameIn, priceIn, unitsLeftIn);
        discountpercentage = discountpercentageIn;

    }

    public double getDiscountpercentage() {
        return discountpercentage;
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
        return super.getPrice()*(1-discountpercentage);
    }

}
