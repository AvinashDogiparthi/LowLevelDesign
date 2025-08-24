package L_WareHouseManagementDesign.Locker.assignStrategy;

import L_WareHouseManagementDesign.Locker.Locker;

import java.util.TreeMap;

public interface LockerAssign {

     Locker getAvailableLocker(TreeMap<Integer,Locker> treeMap);
}
