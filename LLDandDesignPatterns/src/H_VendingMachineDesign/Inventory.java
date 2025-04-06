package H_VendingMachineDesign;

import Z_Exception.DesignErrorEnum;
import Z_Exception.DesignException;

public class Inventory {
    ItemShelf[] inventory  = null;

    Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory){
        this.inventory = inventory;
    }

    public void initialEmptyInventory(){
        int startCode = 101;
        for(int i = 0;i<inventory.length;i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.code ==  codeNumber){
                if(itemShelf.isSoldOut()){
                    itemShelf.item =  item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new DesignException(DesignErrorEnum.ITEM_EXIST,"Already item is present, you cannot add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.code == codeNumber){
                if(itemShelf.isSoldOut()){
                    throw new DesignException(DesignErrorEnum.ITEM_SOLD_OUT,"Item shelf is empty");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new DesignException(DesignErrorEnum.INVALID_CODE,"Provided code doesn't exist in system");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
