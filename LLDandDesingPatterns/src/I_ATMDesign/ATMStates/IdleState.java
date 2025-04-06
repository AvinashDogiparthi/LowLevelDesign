package I_ATMDesign.ATMStates;

import I_ATMDesign.ATM;
import I_ATMDesign.Card;

public class IdleState extends State{
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
