package J_ATMDesign.ATMStates;

import J_ATMDesign.ATM;
import J_ATMDesign.Card;

public class IdleState extends State{
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
