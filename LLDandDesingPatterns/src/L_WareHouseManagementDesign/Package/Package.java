package L_WareHouseManagementDesign.Package;

public class Package {

    private int packageID;
    private String description;
    private PackageSizeEnum packageSizeEnum;

    public Package(int packageID, String description, PackageSizeEnum packageSizeEnum) {
        this.packageID = packageID;
        this.description = description;
        this.packageSizeEnum = packageSizeEnum;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PackageSizeEnum getPackageSizeEnum() {
        return packageSizeEnum;
    }

    public void updatePackageSize(PackageSizeEnum packageSizeEnum) {
        this.packageSizeEnum = packageSizeEnum;
    }
}
