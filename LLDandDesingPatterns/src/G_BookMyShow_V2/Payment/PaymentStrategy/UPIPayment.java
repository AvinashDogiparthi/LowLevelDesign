package G_BookMyShow_V2.Payment.PaymentStrategy;

public class UPIPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("UPIPayment:pay -- payment is processing");
        System.out.println("UPIPayment:pay -- rupees : "+ amount+ "INR payment is done");
    }
}
