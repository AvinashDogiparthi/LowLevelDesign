package DesignPatterns.C_FactoryDesignPattern.Payment;

public class HDFCCreditCard implements CardPayment {
    @Override
    public void pay(){
        verifyCardValidity();
        System.out.println("Processing payment through HDFC Credit Card : payment will be done in few seconds");
        generateOfflineReceipt();
    }

    @Override
    public void generateOfflineReceipt(){
        System.out.println("Generating offline receipt for HDFC Card");
        System.out.println("Thanks for using HDFC Credit Card");
    }

    @Override
    public void verifyCardValidity(){
        System.out.println("Checking HDFC card validity");
    }
}
