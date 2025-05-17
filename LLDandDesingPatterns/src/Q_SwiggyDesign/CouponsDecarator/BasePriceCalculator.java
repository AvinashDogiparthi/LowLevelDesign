package Q_SwiggyDesign.CouponsDecarator;

import Q_SwiggyDesign.User.Customer;

public class BasePriceCalculator implements PriceCalculator{
    private final Customer customer;

    public BasePriceCalculator(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int calculatePrice(){
        return customer.getUserCart().retrieveItemsInCart().stream()
                .mapToInt(item -> item.getCount() * item.getPrice())
                .sum();
    }

}
