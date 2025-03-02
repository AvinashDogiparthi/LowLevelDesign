package DesignPatterns.C_FactoryDesignPattern.Payment;

public class HSBCCreditCard implements CardPayment {
    @Override
    public void pay(){
        verifyCardValidity();
        System.out.println("Processing payment through HSBC Credit Card : payment will be done in few seconds");
        generateOfflineReceipt();
    }

    @Override
    public void generateOfflineReceipt(){
        System.out.println("Generating offline receipt for HSBC Card");
        System.out.println("Thanks for using HSBC Credit Card");
    }

    @Override
    public void verifyCardValidity(){
        System.out.println("Checking HSBC card validity");
    }
}
