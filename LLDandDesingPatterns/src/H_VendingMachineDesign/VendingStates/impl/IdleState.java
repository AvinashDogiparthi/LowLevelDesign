package H_VendingMachineDesign.VendingStates.impl;

import H_VendingMachineDesign.Coin;
import H_VendingMachineDesign.Item;
import H_VendingMachineDesign.VendingStates.State;
import H_VendingMachineDesign.VendingMachine;
import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently system is in idle state");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently machine is in Idle state");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot insert coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot choose Product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot dispense product in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot get full refund in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new DesignException(DesignErrorEnum.WRONG_STATE,"You cannot update inventory in idle state");
    }
}
