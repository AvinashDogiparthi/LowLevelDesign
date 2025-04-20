package N_ZeptoStoreDesign;

import java.util.Map;

public class WareHouseBuilder {
    public int wareHouseId;
    public Map<Integer, Integer> availableProductsCount;
    public Map<Integer, Product> productMap;
    public Location location;
    public String city;

    public WareHouseBuilder withWareHouseID(int id){
        this.wareHouseId = id;
        return this;
    }

    public WareHouseBuilder withAvailableProductsCount(Map<Integer, Integer> availableProductsCount){
        this.availableProductsCount = availableProductsCount;
        return this;
    }

    public WareHouseBuilder withProductMap(Map<Integer, Product> productMap){
        this.productMap = productMap;
        return this;
    }

    public WareHouseBuilder withLocation(Location location){
        this.location = location;
        return this;
    }

    public WareHouseBuilder withCity(String cityName){
        this.city = cityName;
        return this;
    }

    public WareHouse build(){
        return new WareHouse(this);
    }
}
