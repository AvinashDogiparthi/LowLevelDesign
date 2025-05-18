package J_ATMDesign.ATMStates;

import J_ATMDesign.ATM;
import J_ATMDesign.Card;

public class CheckBalanceState extends State{

    public CheckBalanceState(){

    }

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your balance is : "+card.getBankBalance());
        exit(atm);
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
