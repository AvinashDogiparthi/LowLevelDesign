package Q_SwiggyDesign.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(int totalAmountPaid) {
        System.out.println("Total Amount to be paid : "+totalAmountPaid);
        System.out.println("CreditCardPayment :: Processing Payment using credit card");
    }
}
