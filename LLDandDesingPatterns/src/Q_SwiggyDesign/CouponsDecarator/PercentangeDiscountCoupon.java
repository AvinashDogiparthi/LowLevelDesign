package Q_SwiggyDesign.CouponsDecarator;

public class PercentangeDiscountCoupon extends CouponDecorator{

    private final int discountPercentage;

    public PercentangeDiscountCoupon(PriceCalculator priceCalculator, int discountPercentage) {
        super(priceCalculator);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int calculatePrice() {
        int basePrice = priceCalculator.calculatePrice();
        return basePrice - ( basePrice * discountPercentage / 100);
    }
}
