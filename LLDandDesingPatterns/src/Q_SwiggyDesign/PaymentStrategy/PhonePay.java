package Q_SwiggyDesign.PaymentStrategy;

public class PhonePay implements PaymentStrategy{

    @Override
    public void pay(int totalAmountPaid) {
        System.out.println("Total Amount to be paid : "+totalAmountPaid);
        System.out.println("PhonePay :: processing payment through phone pay");
    }
}
