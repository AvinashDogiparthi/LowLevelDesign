package SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy;

import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment.CreditCardPayment;
import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment.OnlinePayment;
import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment.PayPalPayment;
import SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment.Payment;

public class Main {
    public static void main(String[] args) {
        OnlinePayment payPalPayment = new PayPalPayment();
        payPalPayment.pay();
        payPalPayment.generateOnlineReceipt();

        Payment creditCardPayment = new CreditCardPayment(); // instead of depending upon concrete CreditCardPayment class we are using generic one
        creditCardPayment.pay();

        // credit card payment cannot possess generate online receipt as this interface doesn't have that method
        // even if we try it will throw compilation errors


    }
}
