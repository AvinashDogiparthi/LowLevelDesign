package Q_SwiggyDesign.CouponsDecarator;

public abstract class CouponDecorator implements PriceCalculator{

    protected PriceCalculator priceCalculator;

    public CouponDecorator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}
