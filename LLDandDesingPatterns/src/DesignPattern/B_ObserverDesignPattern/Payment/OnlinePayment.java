package DesignPattern.B_ObserverDesignPattern.Payment;

public interface OnlinePayment extends Payment {
    void generateOnlineReceipt();
}
