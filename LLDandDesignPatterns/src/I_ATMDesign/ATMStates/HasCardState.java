package I_ATMDesign.ATMStates;

import I_ATMDesign.ATM;
import I_ATMDesign.Card;

public class HasCardState extends State{

    public HasCardState(){
        System.out.println("Enter your PIN number");
    }

    @Override
    public void authenticatePIN(ATM atm, Card card, int pin){
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

        if(isCorrectPinEntered){
            atm.setCurrentATMState(new SelectionOperationState());
        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happened");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
