package G_BookMyShow_V2.Payment.PaymentStrategy;

import G_BookMyShow_V2.Payment.PaymentFactory;
import Z_Exception.DesignException;

public class PaymentService {

    public void doPayment(PaymentStrategyEnum paymentStrategyEnum, int amount){

        try {
            PaymentStrategy payment = PaymentFactory.getPaymentMethod(paymentStrategyEnum);
            payment.pay(amount);
            System.out.println("PaymentService::doPayment -- Payment is done");
        } catch (DesignException designException){
            System.out.println("PaymentService::doPayment -- Catching the exception as the provided payment method is invalid");
            System.out.println("Error : "+ designException.getMessage());
        }
    }
}
