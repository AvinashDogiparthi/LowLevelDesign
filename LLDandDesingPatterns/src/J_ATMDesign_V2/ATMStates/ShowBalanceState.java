package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;

public class ShowBalanceState implements ATMState {

    @Override
    public void showBalance(ATM atm){
        System.out.println("ShowBalanceState::showBalance -- your card balance will be show now");
        int balanceAvailable = atm.getCard().getUserBankAccount().getBalanceAmount();
        System.out.println("ShowBalanceState::showBalance -- current balance available : "+balanceAvailable);
        atm.setAtmState(new ReturnState());
        System.out.println("ShowBalanceState::showBalance -- your next state is return state, so please act accordingly");
    }
}
