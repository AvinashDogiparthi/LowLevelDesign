package DesignPatterns.C_FactoryDesignPattern.Payment;

public interface CardPayment extends Payment {
    void verifyCardValidity();
    void generateOfflineReceipt();
}
