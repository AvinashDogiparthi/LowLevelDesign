package H_VendingMachineDesign.VendingStates.impl;

import H_VendingMachineDesign.Coin;
import H_VendingMachineDesign.Item;
import H_VendingMachineDesign.VendingMachine;
import H_VendingMachineDesign.VendingStates.State;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine machine, int codeNumber) throws Exception{

        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"Insert coin button cannot be clicked on Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"product selection button cannot be clicked in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"coin cannot be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"product cannot be choosen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"change cannot returned in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(productCode);
        machine.getInventory().updateSoldOutItem(productCode);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"refund cannot be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"inventory cannot be updated in Dispense state");
    }
}
