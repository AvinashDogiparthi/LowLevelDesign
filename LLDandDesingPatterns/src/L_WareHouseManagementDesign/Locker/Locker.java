package L_WareHouseManagementDesign.Locker;

import L_WareHouseManagementDesign.Package.Package;
import L_WareHouseManagementDesign.Package.PackageSizeEnum;

public class Locker {

    private int lockerId;
    private PackageSizeEnum packageSizeEnum;
    private boolean isAvailable;
    private Package assignedPackage;

    public Locker(int lockerId, PackageSizeEnum packageSizeEnum) {
        this.lockerId = lockerId;
        this.packageSizeEnum = packageSizeEnum;
        this.isAvailable = true;
    }

    public int getLockerId() {
        return lockerId;
    }

    public void setLockerId(int lockerId) {
        this.lockerId = lockerId;
    }

    public PackageSizeEnum getPackageSizeEnum() {
        return packageSizeEnum;
    }

    public void updatePackageSize(PackageSizeEnum packageSizeEnum) {
        this.packageSizeEnum = packageSizeEnum;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Package getPackage() {
        return assignedPackage;
    }

    public void add(Package aPackage) {
        assignedPackage = aPackage;
    }
}
