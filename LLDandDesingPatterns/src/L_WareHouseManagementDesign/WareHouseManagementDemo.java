package L_WareHouseManagementDesign;

public class WareHouseManagementDemo {

    public static void main(String[] args) {

        WareHouse wareHouse = WareHouse.getInstance();

        for(int i = 0;i<5;i++){
            wareHouse.createLocker(i,PackageSizeEnum.LARGE);
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


        Package package1 = new Package(11,"it is having pineapple",PackageSizeEnum.SMALL);
        wareHouse.assignPackage(package1);
        wareHouse.unAssignPackage(package1);
    }
}
