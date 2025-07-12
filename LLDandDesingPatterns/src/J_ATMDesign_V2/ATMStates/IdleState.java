package J_ATMDesign_V2.ATMStates;

import J_ATMDesign_V2.ATM;
import J_ATMDesign_V2.Card;

public class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("IdleState::insertCard -- insertion of the card is done, please proceed with next state");
        atm.setAtmState(new InsertCardState());
        atm.setCard(card);
        System.out.println("IdleState::insertCard -- next state is insertCardState, please perform actions accordingly");
    }
}
