package SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment;

public class PayPalPayment implements Payment{

    @Override
    public void pay(){
        System.out.println("Processing payment through PayPal");
    }

    @Override
    public void generateOnlineReceipt(){
        System.out.println("Generating receipt for pay pal payment");
    }
}
