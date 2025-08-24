package L_WareHouseManagementDesign.Locker.assignStrategy;

public class LockerAssignFactory {

    public static LockerAssign getLockerAssigner(LockerAssignStrategy lockerAssignStrategy){
        LockerAssign lockerAssign = new ClosestLockerAssign();
        if(lockerAssignStrategy == LockerAssignStrategy.RANDOM){
            lockerAssign = new RandomLockerAssign();
        }

        return lockerAssign;
    }
}
