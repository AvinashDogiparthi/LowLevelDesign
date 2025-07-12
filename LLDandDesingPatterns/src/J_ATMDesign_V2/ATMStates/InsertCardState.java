package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;

public class InsertCardState implements ATMState {


    @Override
    public void enterPINNumber(ATM atm, int pinNumber){
        System.out.println("InsertCardState::enterPINNumber -- please enter pin number");
        if(pinNumber == atm.getCard().getPinNumber()){
            atm.setAtmState(new SelectionState());
            System.out.println("InsertCardState:enterPINNumber -- next state is selection state, please perform actions accordingly");
        } else {
            System.out.println("InsertCardState::enterPINNumber -- in valid state");
        }
    }
}
