package A_SOLIDPrinciples.LiskovSubstitutionPrincipleAndInterfaceSegregationPrinciple.Satisfy.Payment;

public interface OnlinePayment extends Payment{
    void generateOnlineReceipt();
}
