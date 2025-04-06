package H_VendingMachineDesign.VendingStates;

import H_VendingMachineDesign.Coin;
import H_VendingMachineDesign.Item;
import H_VendingMachineDesign.VendingMachine;

import java.util.List;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception;
    public int getChange(int returnChangeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception;
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception;
}
