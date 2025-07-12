package J_ATMDesign_V2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ATM atm = ATM.getINSTANCE();

        UserBankAccount userBankAccount = new UserBankAccount(10000000);
        Card card = new Card("100100102","03122","10/10/2078","AVINASH",userBankAccount);

        // case 1 : this will fails because we are performing un authorized action in a different state
        atm.getAtmState().showBalance(atm);

        // case 2 : this will be a successfull transaction, as the sequence of actions are correct
        atm.getAtmState().insertCard(atm,card);
        atm.getAtmState().enterPINNumber(atm,001122);
        atm.getAtmState().selectTransactionType(atm,TransactionTypeEnum.SHOW_BALANCE);
        atm.getAtmState().showBalance(atm);
        atm.getAtmState().collectCard(atm);

        // case 3 : this will fails because we are performing un authorized action in a different state
        atm.getAtmState().withDrawMoney(atm,1000);

        // case 4 : this will be a successfull transaction, as the sequence of actions are correct
        atm.getAtmState().insertCard(atm,card);
        atm.getAtmState().enterPINNumber(atm,001122);
        atm.getAtmState().selectTransactionType(atm,TransactionTypeEnum.WITHDRAW);
        atm.getAtmState().withDrawMoney(atm,1000);
        atm.getAtmState().collectCard(atm);

        // case 5 : this will fails because we are performing un authorized action in a different state
        Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap = new HashMap<>();
        currencyNotesEnumIntegerMap.put(CurrencyNotesEnum.TWO_THOUSAND,100);
        atm.getAtmState().depositMoney(atm,currencyNotesEnumIntegerMap);

        // case 6 : this will be a successfull transaction, as the sequence of actions are correct
        atm.getAtmState().insertCard(atm,card);
        atm.getAtmState().enterPINNumber(atm,001122);
        atm.getAtmState().selectTransactionType(atm,TransactionTypeEnum.DEPOSIT);
        atm.getAtmState().depositMoney(atm,currencyNotesEnumIntegerMap);
        atm.getAtmState().collectCard(atm);
    }

}
