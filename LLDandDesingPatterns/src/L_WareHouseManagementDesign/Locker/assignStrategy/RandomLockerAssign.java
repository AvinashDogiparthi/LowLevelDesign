package L_WareHouseManagementDesign.Locker.assignStrategy;

import L_WareHouseManagementDesign.Locker.Locker;

import java.util.Objects;
import java.util.TreeMap;

public class RandomLockerAssign implements LockerAssign {

    @Override
    public Locker getAvailableLocker(TreeMap<Integer, Locker> treeMap) {
        Locker locker = null;

        if(Objects.isNull(treeMap)){
            System.out.println("LockerService::getAvailableLocker-- no such locker is currently available");
        } else {
            locker = treeMap.get(treeMap.lastKey());
        }

        return locker;
    }
}
