package J_ATMDesign_V2.ATMStates;

import J_ATMDesign.Card;
import J_ATMDesign_V2.ATM;

public class ReturnState implements ATMState {

    @Override
    public void collectCard(ATM atm){
        System.out.println("ReturnState::collectCard -- you are at the return state which is the last state of ATM, be ready to collect your card");
        atm.setCard(null);
        System.out.println("ReturnState::collectCard -- please collect your card");
        System.out.println("ReturnState::collectCard -- thanks for using ATM service");
        atm.setAtmState(new IdleState());
    }
}
