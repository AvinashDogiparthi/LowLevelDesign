package E_CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> stores, List<User> users){
        this.storeList = stores;
        this.userList = users;
    }

    public Store getStore(Location location){
        return storeList.get(0);
    }
}
