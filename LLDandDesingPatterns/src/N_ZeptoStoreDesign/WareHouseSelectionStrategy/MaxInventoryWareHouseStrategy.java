package N_ZeptoStoreDesign.WareHouseSelectionStrategy;

import N_ZeptoStoreDesign.Product;
import N_ZeptoStoreDesign.User;
import N_ZeptoStoreDesign.WareHouse;
import N_ZeptoStoreDesign.WareHouseManagement;

import java.util.List;
import java.util.Map;

public class MaxInventoryWareHouseStrategy implements WareHouseSelectionStrategy{

    @Override
    public WareHouse selectWareHouse(User user, List<WareHouse> wareHouseList) {
        WareHouse elgibleWareHouse = null;
        Map<Integer, Integer> requestedProductsByUser = user.getUserCart().selectedProductsCount;
        for(WareHouse wareHouse : wareHouseList){
            boolean eligible = true;
            for(int productId : requestedProductsByUser.keySet()){
                if(!wareHouse.availableProductsCount.containsKey(productId)){
                    eligible = false;
                } else {
                    if(requestedProductsByUser.get(productId) > wareHouse.getAvailableProductsCount().get(productId)){
                        eligible = false;
                    }
                }
            }

            if(eligible){
                elgibleWareHouse = wareHouse;
            }
        }

        return elgibleWareHouse;
    }
}
