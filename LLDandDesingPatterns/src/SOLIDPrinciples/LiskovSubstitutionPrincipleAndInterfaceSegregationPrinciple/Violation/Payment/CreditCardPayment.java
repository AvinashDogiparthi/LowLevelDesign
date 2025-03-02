package SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment;

import Exception.DesignException;
import Exception.DesignErrorEnum;

public class CreditCardPayment implements Payment{

    @Override
    public void pay(){
        System.out.println("Processing credit card payment");
    }

    @Override
    public void generateOnlineReceipt(){
        throw new DesignException(DesignErrorEnum.VIOLATES_LISKOV_SUBSTITUTION_PRINCIPLE,"Credit Card payment cannot generate receipt");
    }
}
