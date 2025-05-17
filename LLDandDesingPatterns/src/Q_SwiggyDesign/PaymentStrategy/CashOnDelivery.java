package Q_SwiggyDesign.PaymentStrategy;

public class CashOnDelivery implements PaymentStrategy{

    @Override
    public void pay(int totalAmountPaid) {
        System.out.println("Total Amount to be paid : "+totalAmountPaid);
        System.out.println("CashOnDelivery :: Delivery associate have to get liquid cash from customer");
    }
}
