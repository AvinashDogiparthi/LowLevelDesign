package J_ATMDesign.ATMStates;

import J_ATMDesign.ATM;
import J_ATMDesign.Card;

public class CashWithdrawalState extends State{

    public CashWithdrawalState(){
        System.out.println("Please enter Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmountRequest){

        if(withdrawalAmountRequest > atm.getAtmBalance()){
            System.out.println("Insufficient funds");
            exit(atm);
        } else if(withdrawalAmountRequest > card.getBankBalance()){
            System.out.println("Your card balance is insufficient");
            exit(atm);
        } else {
            card.deductBankBalance(withdrawalAmountRequest);
            atm.deductATMBalance(withdrawalAmountRequest);

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
