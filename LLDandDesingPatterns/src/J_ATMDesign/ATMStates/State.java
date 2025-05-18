package J_ATMDesign.ATMStates;

import J_ATMDesign.ATM;
import J_ATMDesign.Card;
import J_ATMDesign.TransactionType;

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
