package I_ATMDesign.ATMStates;

import I_ATMDesign.ATM;
import I_ATMDesign.Card;
import I_ATMDesign.TransactionType;

public class SelectionOperationState extends State{

    public SelectionOperationState(){
        System.out.println("Please select an operation");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType){
        switch (transactionType) {
            case CASH_WITHDRAWAL :
                atm.setCurrentATMState(new CashWithdrawalState());
                break;

            case BALANCE_CHECK :
                atm.setCurrentATMState(new CheckBalanceState());
                break;

            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happened");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
