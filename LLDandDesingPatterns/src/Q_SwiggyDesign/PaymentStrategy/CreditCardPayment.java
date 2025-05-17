package Q_SwiggyDesign.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("CreditCardPayment :: Processing Payment using credit card");
    }
}
