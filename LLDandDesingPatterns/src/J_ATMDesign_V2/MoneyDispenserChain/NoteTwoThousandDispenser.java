package J_ATMDesign_V2.MoneyDispenserChain;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;

import java.util.Map;

public class NoteTwoThousandDispenser extends MoneyDispenser{

    public NoteTwoThousandDispenser(MoneyDispenser moneyDispenser){
        super(moneyDispenser);
    }

    @Override
    public void withDrawAmount(int withDrawAmount, ATM atm, Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap){

        if(canHandle(withDrawAmount,2000)){
            int notesNeeded = withDrawAmount/2000;
            int notestInATM = atm.getSpecificCurrencyNotesCount(CurrencyNotesEnum.TWO_THOUSAND);
            int notesNeedToBeremoved = Math.min(notesNeeded,notestInATM);

            currencyNotesEnumIntegerMap.put(CurrencyNotesEnum.TWO_THOUSAND,notesNeedToBeremoved);
            withDrawAmount = withDrawAmount - notesNeedToBeremoved * 2000;
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        } else {
            this.nextMoneyDispenser.withDrawAmount(withDrawAmount,atm,currencyNotesEnumIntegerMap);
        }

    }
}
