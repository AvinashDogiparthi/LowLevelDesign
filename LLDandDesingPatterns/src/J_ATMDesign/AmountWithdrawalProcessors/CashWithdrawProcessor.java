package J_ATMDesign.AmountWithdrawalProcessors;

import J_ATMDesign.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.nextCashWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount){
        if(nextCashWithdrawProcessor != null){
            nextCashWithdrawProcessor.withdraw(atm,remainingAmount);
        }
    }
}
