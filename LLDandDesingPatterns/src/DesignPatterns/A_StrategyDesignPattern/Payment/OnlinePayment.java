package DesignPatterns.A_StrategyDesignPattern.Payment;

public interface OnlinePayment extends Payment{
    void generateOnlineReceipt();
}
