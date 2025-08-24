package L_WareHouseManagementDesign;

import L_WareHouseManagementDesign.Locker.assignStrategy.LockerAssignStrategy;
import L_WareHouseManagementDesign.Package.Package;
import L_WareHouseManagementDesign.Package.PackageSizeEnum;

public class WareHouseManagementDemo {

    public static void main(String[] args) {

        WareHouse wareHouse = WareHouse.getInstance();

        for(int i = 0;i<5;i++){
            wareHouse.createLocker(i, PackageSizeEnum.LARGE);
        }

        for(int i = 10;i<15;i++){
            wareHouse.createLocker(i,PackageSizeEnum.SMALL);
        }

        for(int i = 20;i<25;i++){
            wareHouse.createLocker(i,PackageSizeEnum.EXTRA_LARGE);
        }

        for(int i = 40;i<60;i++){
            wareHouse.createLocker(i,PackageSizeEnum.MEDIUM);
        }


        L_WareHouseManagementDesign.Package.Package package1 = new Package(11,"it is having pineapple",PackageSizeEnum.SMALL);
        wareHouse.assignPackage(package1, LockerAssignStrategy.NEAR_BY);
        wareHouse.unAssignPackage(package1);
    }
}
