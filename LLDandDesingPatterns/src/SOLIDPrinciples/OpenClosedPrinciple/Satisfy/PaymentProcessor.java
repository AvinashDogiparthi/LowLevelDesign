package SOLIDPrinciples.OpenClosedPrinciple.Satisfy;

import SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType.Payment;

public class PaymentProcessor {
    private Payment payment;
    public PaymentProcessor(Payment payment){
        this.payment = payment;
    }

    public void processPayment(){
        payment.pay();
    }
}
