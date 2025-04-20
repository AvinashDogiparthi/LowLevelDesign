package N_ZeptoStoreDesign;

import java.util.Map;

public class WareHouse {
    public int wareHouseId;
    public Map<Integer, Integer> availableProductsCount;
    public Map<Integer, Product> productMap;
    public Location location;
    public String city;

    public WareHouse(WareHouseBuilder wareHouseBuilder) {
        this.wareHouseId = wareHouseBuilder.wareHouseId;
        this.availableProductsCount = wareHouseBuilder.availableProductsCount;
        this.productMap = wareHouseBuilder.productMap;
        this.location = wareHouseBuilder.location;
        this.city = wareHouseBuilder.city;
    }

    public void addProduct(Product product){
        if(productMap.containsKey(product.getProductID())){
            int currentCount = availableProductsCount.get(product.getProductID());
            availableProductsCount.put(product.productID, currentCount+1);
        }else {
            productMap.put(product.productID, product);
            availableProductsCount.put(product.productID, 1);
        }

        System.out.println("Current WareHouse have "+availableProductsCount.get(product.productID)+"  Product : "+product.getProductName());
    }

    public void increaseProductCount(int productID, int count){
        if(productMap.containsKey(productID)){
            Product product = productMap.get(productID);
            int currentCount = availableProductsCount.get(productID);
            int increasedCount = currentCount+count;
            availableProductsCount.put(productID, increasedCount);
            System.out.println("Increased product count of product with id " + productID + " to " + increasedCount);
            System.out.println("Current WareHouse have "+availableProductsCount.get(product.productID)+"  Product : "+product.getProductName());
        } else {
            System.out.println("Product itself doesn't exist, so increment is not possible");
        }
    }

    public void removeProduct(Product product){
        if(productMap.containsKey(product.productID)){
            int currentCount = availableProductsCount.get(product.productID);
            if(currentCount == 0){
                availableProductsCount.remove(product.productID);
                productMap.remove(product.productID);
                System.out.println("Product with id " + product.productID + " removed from warehouse");
            } else if ( currentCount > 0){
                availableProductsCount.put(product.productID, currentCount-1);
                System.out.println("Current WareHouse have "+availableProductsCount.get(product.productID)+"  Product : "+product.getProductName());
            }
        } else {
            System.out.println("Product not in cart");
        }
    }

    public void decreaseProductCount(int productID, int count){
        if(productMap.containsKey(productID)){
            int currentCount = availableProductsCount.get(productID);
            int decreasedCount = currentCount-count;
            if(decreasedCount == 0) {
                availableProductsCount.remove(productID);
                productMap.remove(productID);
                System.out.println("Product with id " + productID + " removed from warehouse");
            } else if (decreasedCount > 0){
                Product product = productMap.get(productID);
                availableProductsCount.put(productID, decreasedCount);
                System.out.println("Decreased product count of product with id " + productID + " to " + decreasedCount);
                System.out.println("Current WareHouse have "+availableProductsCount.get(product.productID)+"  Product : "+product.getProductName());
            }
        } else {
            System.out.println("Product itself doesn't exist, so increment is not possible");
        }
    }

    public int getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(int wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public Map<Integer, Integer> getAvailableProductsCount() {
        return availableProductsCount;
    }

    public void setAvailableProductsCount(Map<Integer, Integer> availableProductsCount) {
        this.availableProductsCount = availableProductsCount;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "WareHouse{" +
                "wareHouseId=" + wareHouseId +
                ", availableProductsCount=" + availableProductsCount +
                ", productMap=" + productMap +
                ", location=" + location +
                ", city='" + city + '\'' +
                '}';
    }
}
