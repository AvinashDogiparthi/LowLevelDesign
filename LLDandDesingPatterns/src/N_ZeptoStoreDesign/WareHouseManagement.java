package N_ZeptoStoreDesign;

import N_ZeptoStoreDesign.WareHouseSelectionStrategy.NearestWareHouseStrategy;
import N_ZeptoStoreDesign.WareHouseSelectionStrategy.WareHouseSelectionStrategy;
import Y_Utils.SystemDesignConstants;

import java.util.*;

public class WareHouseManagement {
    public Map<String, List<WareHouse>> wareHousesVsCityMap;
    public WareHouseSelectionStrategy wareHouseSelectionStrategy;
    public static WareHouseManagement instance = null;
    public Random random = new Random();

    public static WareHouseManagement getInstance(){
        if(instance == null){
            instance = new WareHouseManagement();
            return instance;
        }
        return instance;
    }

    private WareHouseManagement() {
        wareHousesVsCityMap = new HashMap<>();
        addEntitiesToWareHouse();
    }

    public void OrderItemsFromNearestWareHouse(User user, String cityName){
        wareHouseSelectionStrategy = new NearestWareHouseStrategy();
        List<WareHouse> wareHousesList = wareHousesVsCityMap.get(cityName);
        WareHouse wareHouse = wareHouseSelectionStrategy.selectWareHouse(user,wareHousesList);

        System.out.println("Selected warehouse data : "+wareHouse);
        for(int productId : user.userCart.getProductMap().keySet()){
            if(wareHouse.getProductMap()!= null && wareHouse.getProductMap().containsKey(productId)){
                Map<Integer, Integer> selectedProducts = user.getUserCart().getSelectedProductsCount();
                if(selectedProducts.get(productId) > wareHouse.getAvailableProductsCount().get(productId)){
                    System.out.println("Available products count in warehouse is less then requested count which is : "+selectedProducts.get(productId));
                    System.out.println("Sending out only "+ wareHouse.getAvailableProductsCount().get(productId) + " because only that much is available");
                    wareHouse.decreaseProductCount(productId, wareHouse.getAvailableProductsCount().get(productId));
                } else if ( selectedProducts.get(productId) < wareHouse.getAvailableProductsCount().get(productId) ) {
                    System.out.println("Current ordered Product : "+ productId+ " is available in warehouse");
                    wareHouse.decreaseProductCount(productId, selectedProducts.get(productId));
                } else if ( selectedProducts.get(productId) == wareHouse.getAvailableProductsCount().get(productId) ) {
                    System.out.println("Exactly same count of product is available in warehouse");
                    wareHouse.decreaseProductCount(productId, selectedProducts.get(productId));
                }
            } else {
                System.out.println("_______________Nothing left in this warehouse, please add items___________________");
            }
        }

        System.out.println("Order placed successfully from the nearest warehouse");
    }

    public void addEntitiesToWareHouse(){
        List<WareHouse> bangloreCityWareHouses = new ArrayList<>();
        List<WareHouse> chennaiCityWareHouses = new ArrayList<>();
        Product product1 = new Product(11,"Coco-Cola",30);
        Product product2 = new Product(12,"Thumps-up",20);
        Product product3 = new Product(13,"ButterMilk",10);
        Product product4 = new Product(14,"T-shirts",300);
        Product product5 = new Product(15,"Perfume",70);
        Product product6 = new Product(16,"Maggi",70);
        Product product7 = new Product(17,"Dark chocolate",200);
        Product product8 = new Product(18,"Dark chocolate Intense",300);
        Product product9 = new Product(19,"Coco-cao dark chocolate",500);

        WareHouse wareHouse1 = new WareHouseBuilder()
                .withWareHouseID(100)
                .withCity(SystemDesignConstants.CHENNAI)
                .withLocation(new Location(random.nextInt(), random.nextInt()))
                .withProductMap(new HashMap<>())
                .withAvailableProductsCount(new HashMap<>())
                .build();
        wareHouse1.addProduct(product1);
        wareHouse1.increaseProductCount(product1.productID, 10);
        wareHouse1.addProduct(product8);
        wareHouse1.increaseProductCount(product8.productID, 5);

        WareHouse wareHouse2 = new WareHouseBuilder()
                .withWareHouseID(101)
                .withCity(SystemDesignConstants.CHENNAI)
                .withLocation(new Location(random.nextInt(), random.nextInt()))
                .withProductMap(new HashMap<>())
                .withAvailableProductsCount(new HashMap<>())
                .build();

        wareHouse2.addProduct(product1);
        wareHouse2.increaseProductCount(product1.productID, 10);
        wareHouse2.addProduct(product8);
        wareHouse2.increaseProductCount(product8.productID, 5);
        wareHouse2.addProduct(product2);
        wareHouse2.increaseProductCount(product2.productID, 20);
        wareHouse2.addProduct(product9);
        wareHouse2.increaseProductCount(product9.productID, 5);

        chennaiCityWareHouses.add(wareHouse1);
        chennaiCityWareHouses.add(wareHouse2);
        wareHousesVsCityMap.put(SystemDesignConstants.CHENNAI,chennaiCityWareHouses);

        WareHouse wareHouse3 = new WareHouseBuilder()
                .withWareHouseID(102)
                .withCity(SystemDesignConstants.BANGALORE)
                .withLocation(new Location(random.nextInt(), random.nextInt()))
                .withProductMap(new HashMap<>())
                .withAvailableProductsCount(new HashMap<>())
                .build();

        wareHouse3.addProduct(product1);
        wareHouse3.increaseProductCount(product1.productID, 10);
        wareHouse3.addProduct(product8);
        wareHouse3.increaseProductCount(product8.productID, 5);
        wareHouse3.addProduct(product2);
        wareHouse3.increaseProductCount(product2.productID, 20);
        wareHouse3.addProduct(product9);
        wareHouse3.increaseProductCount(product9.productID, 5);
        wareHouse3.addProduct(product3);
        wareHouse3.increaseProductCount(product3.productID, 10);
        wareHouse3.addProduct(product4);
        wareHouse3.increaseProductCount(product4.productID, 5);
        wareHouse3.addProduct(product5);
        wareHouse3.increaseProductCount(product5.productID, 20);
        wareHouse3.addProduct(product6);
        wareHouse3.increaseProductCount(product6.productID, 5);
        wareHouse3.addProduct(product7);
        wareHouse3.increaseProductCount(product7.productID, 5);

        WareHouse wareHouse4 = new WareHouseBuilder()
                .withWareHouseID(103)
                .withCity(SystemDesignConstants.BANGALORE)
                .withLocation(new Location(random.nextInt(), random.nextInt()))
                .withProductMap(new HashMap<>())
                .withAvailableProductsCount(new HashMap<>())
                .build();

        wareHouse4.addProduct(product1);
        wareHouse4.increaseProductCount(product1.productID, 100);
        wareHouse4.addProduct(product8);
        wareHouse4.increaseProductCount(product8.productID, 1);
        wareHouse4.addProduct(product2);
        wareHouse4.increaseProductCount(product2.productID, 11);
        wareHouse4.addProduct(product9);
        wareHouse4.increaseProductCount(product9.productID, 5);
        wareHouse4.addProduct(product3);
        wareHouse4.increaseProductCount(product3.productID, 10);
        wareHouse4.addProduct(product4);
        wareHouse4.increaseProductCount(product4.productID, 5);
        wareHouse4.addProduct(product5);
        wareHouse4.increaseProductCount(product5.productID, 20);

        bangloreCityWareHouses.add(wareHouse3);
        bangloreCityWareHouses.add(wareHouse3);
        wareHousesVsCityMap.put(SystemDesignConstants.BANGALORE,bangloreCityWareHouses);
    }


    public Map<String, List<WareHouse>> getWareHousesVsCityMap() {
        return wareHousesVsCityMap;
    }

    public void setWareHousesVsCityMap(Map<String, List<WareHouse>> wareHousesVsCityMap) {
        this.wareHousesVsCityMap = wareHousesVsCityMap;
    }

    public WareHouseSelectionStrategy getWareHouseSelectionStrategy() {
        return wareHouseSelectionStrategy;
    }

    public void setWareHouseSelectionStrategy(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
    }
}
