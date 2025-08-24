package L_WareHouseManagementDesign;

import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class WareHouse {

    private Map<Integer,Integer> lockerVsPackageMap;
    private Map<Integer,Integer> packageVsLockerMap;
    private LockerService lockerService;
    private static WareHouse instance = null;

    private WareHouse() {
        lockerVsPackageMap = new HashMap<>();
        packageVsLockerMap = new HashMap<>();
        lockerService = new LockerService();
    }

    public static WareHouse getInstance(){
        if(instance == null){
            instance = new WareHouse();
        }

        return instance;
    }


    public void createLocker(int lockerId, PackageSizeEnum packageSizeEnum){
        lockerService.createLocker(lockerId,packageSizeEnum);
    }

    public void updateLocker(int lockerId, PackageSizeEnum packageSizeEnum){
        lockerService.updateLocker(lockerId,packageSizeEnum);
    }

    public void deleteLocker(int lockerId){
        lockerService.deleteLocker(lockerId);
    }

    public void assignPackage(Package packageNeedstoBeassigned){

        PackageSizeEnum packageSizeEnum = packageNeedstoBeassigned.getPackageSizeEnum();

        Locker locker = lockerService.getAvailableLocker(packageSizeEnum);

        if(Objects.isNull(locker)){
            System.out.println("LockerService::assignPackage--no locker is available with the package size");
        } else{
            lockerService.assignPackageToLocker(locker.getLockerId(),packageNeedstoBeassigned);
            this.lockerVsPackageMap.put(locker.getLockerId(), packageNeedstoBeassigned.getPackageID());
            this.packageVsLockerMap.put(packageNeedstoBeassigned.getPackageID(), locker.getLockerId());
            System.out.println("WareHouse::assignPackage-- successfully assigned locker");
        }
    }


    public void unAssignPackage(Package packageNeedstobeUnassigned){

        if(this.packageVsLockerMap.containsKey(packageNeedstobeUnassigned.getPackageID())){

            int lockerID = packageVsLockerMap.get(packageNeedstobeUnassigned.getPackageID());
            lockerService.unAssignPackageToLocker(lockerID);

            this.lockerVsPackageMap.remove(lockerID);
            this.packageVsLockerMap.remove(packageNeedstobeUnassigned.getPackageID());

            System.out.println("WareHouse::unAssignPackage--successfully un assigned package");

        } else {
            System.out.println("LockerService::unAssignPackage--no such package got assigned any time");
        }
    }
}
