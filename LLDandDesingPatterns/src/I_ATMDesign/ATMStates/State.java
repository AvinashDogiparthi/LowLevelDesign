package I_ATMDesign.ATMStates;

import I_ATMDesign.ATM;
import I_ATMDesign.Card;
import I_ATMDesign.TransactionType;

public abstract class State {

    public void insertCard(ATM atm, Card card){
        System.out.println("OOPS! Something went wrong");
    }

    public void authenticatePIN(ATM atm, Card card, int pin){
        System.out.println("OOPS! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType){
        System.out.println("OOPS! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
        System.out.println("OOPS! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS! Something went wrong");
    }

    public void exit(ATM atm){
        System.out.println("OOPS! Something went wrong");
    }
}
