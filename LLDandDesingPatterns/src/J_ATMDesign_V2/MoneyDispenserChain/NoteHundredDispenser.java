package J_ATMDesign_V2.MoneyDispenserChain;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;

import java.util.Map;

public class NoteHundredDispenser extends MoneyDispenser{

    public NoteHundredDispenser(MoneyDispenser moneyDispenser){
        super(moneyDispenser);
    }

    @Override
    public void withDrawAmount(int withDrawAmount, ATM atm, Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap){

        if(canHandle(withDrawAmount,100)){
            int notesNeeded = withDrawAmount/100;
            int notestInATM = atm.getSpecificCurrencyNotesCount(CurrencyNotesEnum.HUNDRED);
            int notesNeedToBeremoved = Math.min(notesNeeded,notestInATM);

            currencyNotesEnumIntegerMap.put(CurrencyNotesEnum.HUNDRED,notesNeedToBeremoved);
            withDrawAmount = withDrawAmount - notesNeedToBeremoved * 100;
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        } else {
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        }

    }
}
