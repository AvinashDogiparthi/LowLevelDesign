package J_ATMDesign_V2.MoneyDispenserChain;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;

import java.util.Map;

public class NoteFiveHundredDispenser extends MoneyDispenser{

    public NoteFiveHundredDispenser(MoneyDispenser moneyDispenser){
        super(moneyDispenser);
    }

    @Override
    public void withDrawAmount(int withDrawAmount, ATM atm, Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap){

        if(canHandle(withDrawAmount,500)){
            int notesNeeded = withDrawAmount/500;
            int notestInATM = atm.getSpecificCurrencyNotesCount(CurrencyNotesEnum.FIVE_HUNDRED);
            int notesNeedToBeremoved = Math.min(notesNeeded,notestInATM);

            currencyNotesEnumIntegerMap.put(CurrencyNotesEnum.FIVE_HUNDRED,notesNeedToBeremoved);
            withDrawAmount = withDrawAmount - notesNeedToBeremoved * 500;
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        } else {
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        }

    }
}
