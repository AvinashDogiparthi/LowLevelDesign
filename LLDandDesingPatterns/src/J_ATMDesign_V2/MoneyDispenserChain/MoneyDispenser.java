package J_ATMDesign_V2.MoneyDispenserChain;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;

import java.util.Map;

public abstract class MoneyDispenser {

    public MoneyDispenser nextMoneyDispenser;

    MoneyDispenser(MoneyDispenser nextMoneyDispenser){
        this.nextMoneyDispenser = nextMoneyDispenser;
    }

    public void withDrawAmount(int withDrawAmount, ATM atm, Map<CurrencyNotesEnum,Integer> currencyNotesEnumIntegerMap){
        if(nextMoneyDispenser != null){
            nextMoneyDispenser.withDrawAmount(withDrawAmount,atm, currencyNotesEnumIntegerMap);
        }
    }

    public boolean canHandle(int amount, int currencyvalue){
        if(amount > currencyvalue){
            return true;
        } else {
            return false;
        }
    }
}
