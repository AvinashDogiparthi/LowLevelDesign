package SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation;

import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment.CreditCardPayment;
import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment.PayPalPayment;
import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment.Payment;

public class Main {

    public static void main(String[] args) {
        Payment payPalPayment = new PayPalPayment();
        payPalPayment.pay();
        payPalPayment.generateOnlineReceipt();

        Payment creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();
        creditCardPayment.generateOnlineReceipt();

        // if we substitute creditCardPayment with payPalPayment at 10 .. run time exception will occur as creditCardPayment cannot generate receipt
        // no compile time issues will be detected but run time failures will occur
    }
}
