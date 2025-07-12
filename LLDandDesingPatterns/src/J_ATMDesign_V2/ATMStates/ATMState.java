package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.Card;
import J_ATMDesign_V2.CurrencyNotesEnum;
import J_ATMDesign_V2.TransactionTypeEnum;

import java.util.Map;

public interface ATMState {

    // idle state
    default void insertCard(ATM atm, Card card){
        System.out.println("OOPS !! invalid state for inserting card");
    }

    // insert card state
    default void enterPINNumber(ATM atm, int pinNumber){
        System.out.println("OOPS !! invalid state for entering PIN Number");
    }

    // selection state
    default void selectTransactionType(ATM atm, TransactionTypeEnum transactionTypeEnum){
        System.out.println("OOPS !! invalid state for selecting transaction type");
    }

    // show balance state
    default void showBalance(ATM atm){
        System.out.println("OOPS !! invalid state for showing balance");
    }

    // withDraw state
    default void withDrawMoney(ATM atm, int withDrawAmount){
        System.out.println("OOPS !! invalid state for with drawing money");
    }

    // deposit state
    default void depositMoney(ATM atm, Map<CurrencyNotesEnum,Integer> moneyToBeDeposited){
        System.out.println("OOPS !! invalid state for depositing money");
    }

    // return state
    default void collectCard(ATM atm){
        System.out.println("OOPS !! invalid state for collecting card");
    }
}
