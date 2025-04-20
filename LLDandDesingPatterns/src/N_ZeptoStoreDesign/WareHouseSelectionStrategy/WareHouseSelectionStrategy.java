package N_ZeptoStoreDesign.WareHouseSelectionStrategy;

import N_ZeptoStoreDesign.User;
import N_ZeptoStoreDesign.WareHouse;
import N_ZeptoStoreDesign.WareHouseManagement;

import java.util.List;

public interface WareHouseSelectionStrategy {
    public WareHouse selectWareHouse(User user, List<WareHouse> wareHouseList);
}
