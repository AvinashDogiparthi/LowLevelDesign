package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.CurrencyNotesEnum;

import java.util.Map;

public class DepositState implements ATMState {

    @Override
    public void depositMoney(ATM atm, Map<CurrencyNotesEnum,Integer> moneyToBeDeposited){
        System.out.println("DepositState::depositMoney -- depositing money into the user bank account");
        int amountSentByUser = 0;

        for(CurrencyNotesEnum currencyNotesEnum : moneyToBeDeposited.keySet()){
            int currencyValue = currencyNotesEnum.getPrice();
            int notesSent = moneyToBeDeposited.get(currencyNotesEnum);

            atm.addCurrencyNotes(currencyNotesEnum,notesSent);

            int totalValue = currencyValue * notesSent;
            amountSentByUser = amountSentByUser + totalValue;
        }

        atm.getCard().getUserBankAccount().increaseBalance(amountSentByUser);
        System.out.println("DepositState::depositMoney -- deposited "+ amountSentByUser+" into user bank account");
        atm.setAtmState(new ReturnState());
        System.out.println("DepositState::depositMoney -- your next state is return state, so please act accordingly");
    }
}
