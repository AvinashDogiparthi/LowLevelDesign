package B_DesignPatterns.A_StrategyDesignPattern.Payment;

public interface CardPayment extends Payment{
    void verifyCardValidity();
    void generateOfflineReceipt();
}
