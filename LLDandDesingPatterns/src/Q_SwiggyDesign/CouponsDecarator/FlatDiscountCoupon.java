package Q_SwiggyDesign.CouponsDecarator;

public class FlatDiscountCoupon extends CouponDecorator{

    private final int flatDiscountAmount;

    public FlatDiscountCoupon(PriceCalculator priceCalculator, int flatDiscountAmount) {
        super(priceCalculator);
        this.flatDiscountAmount = flatDiscountAmount;
    }

    @Override
    public int calculatePrice(){
        int basePrice = priceCalculator.calculatePrice();
        return Math.max(0, basePrice - flatDiscountAmount);
    }
}
