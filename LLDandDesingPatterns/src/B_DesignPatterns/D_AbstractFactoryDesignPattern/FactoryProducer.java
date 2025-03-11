package B_DesignPatterns.D_AbstractFactoryDesignPattern;

import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.CreditCardFactory;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PayPalFactory;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentAbstractFactory;
import Exception.DesignException;
import Exception.DesignErrorEnum;

public class FactoryProducer {

    public static PaymentAbstractFactory getFactory(String type){
        if(type.equalsIgnoreCase("CREDIT")){
            return new CreditCardFactory();
        } else if (type.equalsIgnoreCase("PAYPAL")){
            return new PayPalFactory();
        }
        throw new DesignException(DesignErrorEnum.UNKNOWN_PAYMENT_METHOD,"Payment method is un-available right now");
    }
}
