package N_ZeptoStoreDesign.WareHouseSelectionStrategy;

import N_ZeptoStoreDesign.User;
import N_ZeptoStoreDesign.WareHouse;

import java.util.List;

public class NearestWareHouseStrategy implements WareHouseSelectionStrategy{

    @Override
    public WareHouse selectWareHouse(User user, List<WareHouse> wareHouseList) {
        WareHouse nearByWareHouse = null;
        int currentMinDistance = Integer.MAX_VALUE;
        for(WareHouse wareHouse : wareHouseList){
            int distance = wareHouse.location.getDistance(user.userLocation);
            if(distance<currentMinDistance){
                currentMinDistance = distance;
                nearByWareHouse = wareHouse;
            }
        }
        return nearByWareHouse;
    }
}
