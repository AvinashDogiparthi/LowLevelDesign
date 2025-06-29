package G_BookMyShow_V2.Payment;

import G_BookMyShow_V2.Payment.PaymentStrategy.*;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

public class PaymentFactory {

    public static PaymentStrategy getPaymentMethod(PaymentStrategyEnum paymentStrategyEnum) {

        switch (paymentStrategyEnum) {
            case UPI:
                return new UPIPayment();
            case CREDIT_CARD:
                return new CreditCardPayment();
            case DEBIT_CARD:
                return new DebitCard();
            default:
                throw new DesignException(DesignErrorEnum.UNKNOWN_PAYMENT_METHOD,"Invalid payment method found");
        }
    }
}
