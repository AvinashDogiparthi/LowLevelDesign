package V_HotelManagementSystem.PaymentStrategy;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentStrategyEnum paymentStrategyEnum){

        if(paymentStrategyEnum == PaymentStrategyEnum.UPI_PAYMENT){
            return new UPIPayment();
        } else if (paymentStrategyEnum == PaymentStrategyEnum.DEBIT_CARD){
            return new DebitCardPayment();
        } else {
            return new CreditCardPayment();
        }
    }
}
