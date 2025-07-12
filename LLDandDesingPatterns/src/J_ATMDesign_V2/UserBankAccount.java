package J_ATMDesign_V2;

public class UserBankAccount {

    private int balanceAmount;

    public UserBankAccount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void reduceBalance(int amountToBeReduce){
        this.balanceAmount = this.balanceAmount - amountToBeReduce;
    }

    public void increaseBalance(int amountToBeIncrease){
        this.balanceAmount = this.balanceAmount + amountToBeIncrease;
    }
}
