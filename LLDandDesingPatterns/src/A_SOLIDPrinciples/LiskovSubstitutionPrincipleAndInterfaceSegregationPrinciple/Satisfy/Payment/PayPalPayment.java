package A_SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment;

public class PayPalPayment implements OnlinePayment{

    @Override
    public void pay(){
        System.out.println("Processing PayPalPayment");
    }

    @Override
    public void generateOnlineReceipt(){
        System.out.println("Generating receipt for PayPalPayment");
    }
}
