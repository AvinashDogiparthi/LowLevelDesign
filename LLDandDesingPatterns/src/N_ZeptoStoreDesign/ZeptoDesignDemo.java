package N_ZeptoStoreDesign;

import Y_Utils.SystemDesignConstants;

import java.util.Random;

public class ZeptoDesignDemo {

    public static void main(String[] args) {
        WareHouseManagement wareHouseManagement = WareHouseManagement.getInstance();

        Random random = new Random();
        Cart cart = new Cart();
        Product butterMilk = new Product(11,"ButterMilk",10);
        Product tshirt = new Product(12,"T-shirts",300);
        Product darkChocolate = new Product(19,"Coco-cao dark chocolate",500);

        cart.addProduct(butterMilk);
        cart.addProduct(butterMilk);
        cart.addProduct(butterMilk);

        cart.addProduct(tshirt);
        cart.addProduct(tshirt);

        cart.addProduct(darkChocolate);

        User user = new UserBuilder()
                .withUserID(112)
                .withUserName("Avinash")
                .withUserLocation(new Location(random.nextInt(), random.nextInt()))
                .withCityName(SystemDesignConstants.BANGALORE)
                .withCart(cart)
                .build();

        System.out.println("----------------User transaction is being initiated--------------------");

        wareHouseManagement.OrderItemsFromNearestWareHouse(user,SystemDesignConstants.BANGALORE);

        System.out.println("----------------User transaction is ended--------------------");

        System.out.println("----------------User transaction is being initiated--------------------");

        wareHouseManagement.OrderItemsFromNearestWareHouse(user,SystemDesignConstants.BANGALORE);

        System.out.println("----------------User transaction is ended--------------------");

        System.out.println("----------------User transaction is being initiated--------------------");

        wareHouseManagement.OrderItemsFromNearestWareHouse(user,SystemDesignConstants.BANGALORE);

        System.out.println("----------------User transaction is ended--------------------");


    }
}
