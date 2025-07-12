package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.TransactionTypeEnum;

public class SelectionState implements ATMState {

    @Override
    public void selectTransactionType(ATM atm, TransactionTypeEnum transactionTypeEnum){
        System.out.println("SelectionState::selectTransactionType -- selecting transaction based on user preference");
        atm.setAtmState(TransactionTypeSelectionFactory.getTransactionType(transactionTypeEnum));
    }
}
