package DesignPattern.B_ObserverDesignPattern.Payment;


public interface CardPayment extends Payment {
    void verifyCardValidity();
    void generateOfflineReceipt();
}
