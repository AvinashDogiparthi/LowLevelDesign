package Q_SwiggyDesign.PaymentStrategy;

public class PhonePay implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("PhonePay :: processing payment through phone pay");
    }
}
