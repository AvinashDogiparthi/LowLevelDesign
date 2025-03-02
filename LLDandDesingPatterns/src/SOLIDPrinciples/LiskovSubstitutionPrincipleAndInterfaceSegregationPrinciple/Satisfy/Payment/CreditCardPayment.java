package SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment;

public class CreditCardPayment implements Payment{

    @Override
    public void pay(){
        System.out.println("Processing credit card payment");
    }
}
