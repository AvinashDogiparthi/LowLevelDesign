package A_SOLIDPrinciples.OpenClosedPrinciple.Satisfy;

import A_SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType.Payment;

public class PaymentProcessor {
    private Payment payment;
    public PaymentProcessor(Payment payment){
        this.payment = payment;
    }

    public void processPayment(){
        payment.pay();
    }
}
