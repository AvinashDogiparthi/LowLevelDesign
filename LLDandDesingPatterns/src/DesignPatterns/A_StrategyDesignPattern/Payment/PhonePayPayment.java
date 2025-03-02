package DesignPatterns.A_StrategyDesignPattern.Payment;

public class PhonePayPayment implements OnlinePayment{
    @Override
    public void pay(){
        System.out.println("Processing payment through Phone Pay Payment application : payment will be done in few seconds");
        generateOnlineReceipt();
    }

    @Override
    public void generateOnlineReceipt(){
        System.out.println("Generating online receipt");
        System.out.println("Thanks for using Phone Pay Payment application for your transaction");

    }
}
