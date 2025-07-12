package J_ATMDesign_V2.MoneyDispenserChain;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

import java.util.Map;

public class NoteTwentyDispenser extends MoneyDispenser{

    public NoteTwentyDispenser(){
        super(null);
    }

    @Override
    public void withDrawAmount(int withDrawAmount, ATM atm, Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap){

        if(canHandle(withDrawAmount,20)){
            int notesNeeded = withDrawAmount/20;
            int notestInATM = atm.getSpecificCurrencyNotesCount(CurrencyNotesEnum.TWENTY);
            int notesNeedToBeremoved = Math.min(notesNeeded,notestInATM);

            currencyNotesEnumIntegerMap.put(CurrencyNotesEnum.TWENTY,notesNeedToBeremoved);
            withDrawAmount = withDrawAmount - notesNeedToBeremoved * 20;

            if(withDrawAmount > 0){
                throw new DesignException(DesignErrorEnum.INSUFFICIENT_AMOUNT,"In sufficient amount in atm");
            } else {
                removeCurrenciesFromATMMap(atm, currencyNotesEnumIntegerMap);
            }
        }  else {

            if(withDrawAmount == 0){
                removeCurrenciesFromATMMap(atm, currencyNotesEnumIntegerMap);
            } else {
                throw new DesignException(DesignErrorEnum.INSUFFICIENT_AMOUNT,"In sufficient amount");
            }
        }

    }

    private static void removeCurrenciesFromATMMap(ATM atm, Map<CurrencyNotesEnum, Integer> currencyNotesEnumIntegerMap) {

        int totalAmountToBeRemoved = 0;
        for(CurrencyNotesEnum currencyNotesEnum : currencyNotesEnumIntegerMap.keySet()){

            int notesToBeRemoved = currencyNotesEnumIntegerMap.get(currencyNotesEnum);
            totalAmountToBeRemoved = totalAmountToBeRemoved + currencyNotesEnum.getPrice() * notesToBeRemoved;
            atm.removeCurrencyNotes(currencyNotesEnum,notesToBeRemoved);

        }

        System.out.println("Amount "+totalAmountToBeRemoved+ " removed from user account, please collect money");

        atm.getCard().getUserBankAccount().reduceBalance(totalAmountToBeRemoved);
    }
}
