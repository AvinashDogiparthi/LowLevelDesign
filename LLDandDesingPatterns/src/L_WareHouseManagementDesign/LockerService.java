package L_WareHouseManagementDesign;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class LockerService {

    private Map<Integer,Locker> lockerMap;
    private Map<Integer,Locker> occupiedLockersMap;
    private Map<PackageSizeEnum, TreeMap<Integer,Locker>> availableLockersMap;

    public LockerService() {
        this.occupiedLockersMap = new HashMap<>();
        this.availableLockersMap = new HashMap<>();
        this.lockerMap = new HashMap<>();
    }

    public void createLocker(int lockerID,PackageSizeEnum packageSizeEnum){

        if(lockerMap.containsKey(lockerID)){
            System.out.println("LockerService::createLocker -- already locker exist with same lockerID, choose a different one");
        } else {
            Locker locker = new Locker(lockerID,packageSizeEnum);
            lockerMap.put(lockerID,locker);
            TreeMap<Integer,Locker> availableMap = availableLockersMap.get(packageSizeEnum);

            if(Objects.isNull(availableMap)){

                TreeMap<Integer,Locker> newMap = new TreeMap<>();
                newMap.put(lockerID,locker);
                availableLockersMap.put(packageSizeEnum,newMap);
            } else {
                availableMap.put(lockerID,locker);
            }
        }
    }

    public void updateLocker(int lockerID, PackageSizeEnum packageSizeEnum){
        if(!lockerMap.containsKey(lockerID)){
            System.out.println("LockerService::updateLocker--no such locker exist, please create a new one");
        } else {
            Locker locker = lockerMap.get(lockerID);

            TreeMap<Integer,Locker> lockerTreeMap = availableLockersMap.get(locker.getPackageSizeEnum());
            if(packageSizeEnum != locker.getPackageSizeEnum()){
                System.out.println("LockerService::updateLocker-- removing locker from older packagesizeenum available map");
                lockerTreeMap.remove(lockerID);

                TreeMap<Integer,Locker> latestSizePackageAvailableMap = availableLockersMap.get(packageSizeEnum);
                locker.updatePackageSize(packageSizeEnum);

                if(Objects.isNull(latestSizePackageAvailableMap)){
                    TreeMap<Integer,Locker> newAvailableMap = new TreeMap<>();
                    newAvailableMap.put(lockerID,locker);
                    this.availableLockersMap.put(packageSizeEnum,newAvailableMap);
                } else {
                    latestSizePackageAvailableMap.put(lockerID,locker);
                }
            } else {
                System.out.println("LockerService::updateLocker-- not doing anything as both packageSize is same");
            }
        }
    }

    public void deleteLocker(int lockerId){

        if(lockerMap.containsKey(lockerId)){
            Locker locker = lockerMap.get(lockerId);

            this.lockerMap.remove(lockerId);
            PackageSizeEnum packageSizeEnum = locker.getPackageSizeEnum();

            TreeMap<Integer,Locker> availableTreeMap = this.availableLockersMap.get(packageSizeEnum);
            availableTreeMap.remove(lockerId);

            System.out.println("LockerService::deleteLocker--Successfully deleted locker");
        } else {
            System.out.println("LockerService::deleteLocker-- no such locker exist");
        }
    }

    public Locker getLocker(int lockerId){
        return this.lockerMap.get(lockerId);
    }

    public Locker getAvailableLocker(PackageSizeEnum packageSizeEnum){

        TreeMap<Integer,Locker> treeMap = this.availableLockersMap.get(packageSizeEnum);

        if(Objects.isNull(treeMap)){
            System.out.println("LockerService::getAvailableLocker-- no such locker is currently available");
        } else {
            Locker locker = treeMap.get(treeMap.firstEntry().getKey());
            return locker;
        }

        return null;
    }

    public void assignPackageToLocker(int lockerID,Package assignedPackage){
        if(lockerMap.containsKey(lockerID)){
            Locker locker = lockerMap.get(lockerID);

            if(locker.isAvailable()){
                locker.setAvailable(false);
                locker.add(assignedPackage);

                TreeMap<Integer,Locker> lockerTreeMap = this.availableLockersMap.get(locker.getPackageSizeEnum());
                lockerTreeMap.remove(lockerID);

                this.occupiedLockersMap.put(lockerID,locker);
            } else {
                System.out.println("LockerService::assignPackageToLocker--locker is not available, please use another locker");
            }
        } else {
            System.out.println("LockerService::assignPackageToLocker -- no such locker exist");
        }
    }

    public void unAssignPackageToLocker(int lockerId){

        if(lockerMap.containsKey(lockerId)){

            if(occupiedLockersMap.containsKey(lockerId)){
                Locker locker = lockerMap.get(lockerId);

                locker.setAvailable(true);
                locker.add(null);
                occupiedLockersMap.remove(lockerId);
            } else {
                System.out.println("LockerService::unAssignPackageToLocker -- it is not occupied");
            }

            this.occupiedLockersMap.remove(lockerId);
        } else {
            System.out.println("LockerService::unAssignPackageToLocker -- no such locker exist");
        }
    }
}
