package I_ATMDesign;

public class UserBankAccount {

    int balance;

    public void withdrawalBalance(int amount){
        balance = balance - amount;
    }
}
