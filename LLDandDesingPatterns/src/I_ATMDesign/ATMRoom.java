package I_ATMDesign;

public class ATMRoom {
    User user;
    ATM atm;

    public static void main(String[] args){
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePIN(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
    }


    public void initialize() {
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500,1,2,5);
        this.user = createUser();
    }

    public User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    public Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    public UserBankAccount createBankAccount(){
        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.balance =  3000;
        return userBankAccount;
    }
}
