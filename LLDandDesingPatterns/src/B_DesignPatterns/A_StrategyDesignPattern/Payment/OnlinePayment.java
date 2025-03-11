package B_DesignPatterns.A_StrategyDesignPattern.Payment;

public interface OnlinePayment extends Payment{
    void generateOnlineReceipt();
}
