package SOLIDPrinciples.OpenClosedPrinciple.Violation;

public class PaymentProcessor {
    public void processPayment(String paymentType){
        if(paymentType.equals("creditCard")){
            System.out.println("Processing credit card payment ...");
        } else if ( paymentType.equals("payPal")){
            System.out.println("Processing PayPal payment ...");
        }
        // PaymentProcessor violates the Open/Closed Principle because it is not closed for modification.
        // if we want to add any other new payment we have to modify this class which is not a good practice.
    }
}
