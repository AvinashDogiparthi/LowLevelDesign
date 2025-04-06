package B_DesignPatterns.C_FactoryDesignPattern.Payment;

public interface OnlinePayment extends Payment {
    void generateOnlineReceipt();
}
