package A_SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType;

public class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment ...");
    }
}
