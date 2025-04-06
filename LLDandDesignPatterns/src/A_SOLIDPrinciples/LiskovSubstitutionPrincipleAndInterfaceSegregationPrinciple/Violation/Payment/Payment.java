package A_SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Violation.Payment;

public interface Payment {
    void pay();
    void generateOnlineReceipt();
}
