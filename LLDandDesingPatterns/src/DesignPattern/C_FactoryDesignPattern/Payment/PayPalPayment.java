package DesignPattern.C_FactoryDesignPattern.Payment;

public class PayPalPayment implements OnlinePayment {
    @Override
    public void pay(){
        System.out.println("Processing payment through Pay Pal Payment application : payment will be done in few seconds");
        generateOnlineReceipt();
    }

    @Override
    public void generateOnlineReceipt(){
        System.out.println("Generating online receipt");
        System.out.println("Thanks for using Pay Pal Payment application for your transaction");
    }
}
