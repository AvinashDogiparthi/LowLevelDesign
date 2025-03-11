package A_SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType;

public class PayPalPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Processing PayPal payment ...");
    }
}
