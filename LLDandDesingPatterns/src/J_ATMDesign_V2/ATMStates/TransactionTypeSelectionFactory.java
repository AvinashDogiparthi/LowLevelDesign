package J_ATMDesign_V2.ATMStates;

import J_ATMDesign.ATMRoom;
import J_ATMDesign_V2.TransactionTypeEnum;

public class TransactionTypeSelectionFactory {

    public static ATMState getTransactionType(TransactionTypeEnum transactionTypeEnum){

        if(transactionTypeEnum == TransactionTypeEnum.DEPOSIT){
            System.out.println("TransactionTypeSelectionFactory::getTransactionType -- your next state is Deposit state, so please act accordingly");
            return new DepositState();
        } else if (transactionTypeEnum == TransactionTypeEnum.WITHDRAW){
            System.out.println("TransactionTypeSelectionFactory::getTransactionType -- your next state is Withdraw state, so please act accordingly");
            return new WithdrawState();
        } else {
            System.out.println("TransactionTypeSelectionFactory::getTransactionType -- your next state is ShowBalance state, so please act accordingly");
            return new ShowBalanceState();
        }
    }
}
