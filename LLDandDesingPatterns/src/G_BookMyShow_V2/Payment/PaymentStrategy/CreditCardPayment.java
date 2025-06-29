package G_BookMyShow_V2.Payment.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("CreditCardPayment:pay -- payment is processing");
        System.out.println("CreditCardPayment:pay -- rupees : "+ amount+ "INR payment is done");
    }
}
