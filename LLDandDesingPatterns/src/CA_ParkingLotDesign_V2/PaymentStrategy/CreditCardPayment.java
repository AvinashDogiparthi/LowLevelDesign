package CA_ParkingLotDesign_V2.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay() {
        // Logic for credit card payment
        System.out.println("Payment made using Credit Card.");
    }
}
