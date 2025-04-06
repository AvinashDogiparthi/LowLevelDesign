package H_VendingMachineDesign.VendingStates.impl;

import H_VendingMachineDesign.Coin;
import H_VendingMachineDesign.Item;
import H_VendingMachineDesign.VendingStates.State;
import H_VendingMachineDesign.VendingMachine;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

import java.util.List;

public class SelectionState implements State {

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        Item item = machine.getInventory().getItem(productCode);

        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()){
            paidByUser = paidByUser + coin.value;
        }

        if(paidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price : "+ item.getPrice()+" and you paid : "+paidByUser);
            refundFullMoney(machine);
            throw new DesignException(DesignErrorEnum.INSUFFICIENT_AMOUNT,"Insufficient amount");
        }

        if(paidByUser > item.getPrice()){
            getChange(paidByUser-item.getPrice());
            machine.setVendingMachineState(new DispenseState(machine, productCode));
        }

        if(paidByUser == item.getPrice()){
            machine.setVendingMachineState(new DispenseState(machine, productCode));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {

    }
}
