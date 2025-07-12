package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;
import J_ATMDesign_V2.MoneyDispenserChain.*;
import Z_Exception.DesignException;

import java.util.HashMap;
import java.util.Map;

public class WithdrawState implements ATMState {

    @Override
    public void withDrawMoney(ATM atm, int withDrawAmount){
        if(withDrawAmount > atm.getCard().getUserBankAccount().getBalanceAmount()){
            System.out.println("Insufficient balance in user bank account");
        } else {

            try{
                MoneyDispenser moneyDispenser = creteChainOfDispense();
                Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap = new HashMap<>();
                moneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
                atm.setAtmState(new ReturnState());
            } catch (DesignException e){
                System.out.println(e.getMessage());
                System.out.println("Please select amount which is available in user account");
            }
        }
    }

    public MoneyDispenser creteChainOfDispense(){
        NoteTwentyDispenser noteTwentyDispenser = new NoteTwentyDispenser();
        NoteHundredDispenser noteHundredDispenser = new NoteHundredDispenser(noteTwentyDispenser);
        NoteFiveHundredDispenser noteFiveHundredDispenser = new NoteFiveHundredDispenser(noteHundredDispenser);
        NoteTwoThousandDispenser noteTwoThousandDispenser = new NoteTwoThousandDispenser(noteFiveHundredDispenser);
        return noteTwoThousandDispenser;
    }
}
