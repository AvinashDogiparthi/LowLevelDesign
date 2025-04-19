package M_UberDesign;

import M_UberDesign.Models.Rider;

public class PaymentProcessor {

    public void removeMoneyFromUserWallet(Rider rider, int rideCost){
        System.out.println("Processing payment for ride cost: " + rideCost);
        rider.walletCash = rider.walletCash - rideCost;
    }
}
