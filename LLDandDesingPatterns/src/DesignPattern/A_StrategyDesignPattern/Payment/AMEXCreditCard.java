package DesignPattern.A_StrategyDesignPattern.Payment;

public class AMEXCreditCard implements CardPayment{
    @Override
    public void pay(){
        verifyCardValidity();
        System.out.println("Processing payment through AMEX Credit Card : payment will be done in few seconds");
        generateOfflineReceipt();
    }

    @Override
    public void generateOfflineReceipt(){
        System.out.println("Generating offline receipt for AMEX Card");
        System.out.println("Thanks for using AMEX Credit Card");
    }

    @Override
    public void verifyCardValidity(){
        System.out.println("Checking AMEX card validity");
    }
}
