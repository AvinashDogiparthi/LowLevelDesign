package CA_ParkingLotDesign_V2.PaymentStrategy;


public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentStrategyEnum paymentStrategyEnum){

        if(paymentStrategyEnum == PaymentStrategyEnum.UPI){
            return new UPIPayment();
        } else if (paymentStrategyEnum == PaymentStrategyEnum.CREDIT_CARD){
            return new CreditCardPayment();
        } else {
            return new DebitCardPayment();
        }
    }
}
