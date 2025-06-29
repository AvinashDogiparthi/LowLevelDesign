package G_BookMyShow_V2.Payment.PaymentStrategy;

public class DebitCard implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("DebitCard:pay -- payment is processing");
        System.out.println("DebitCard:pay -- rupees : "+ amount+ "INR payment is done");
    }
}
