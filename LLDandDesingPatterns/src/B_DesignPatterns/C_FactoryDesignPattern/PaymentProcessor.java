package B_DesignPatterns.C_FactoryDesignPattern;

import B_DesignPatterns.C_FactoryDesignPattern.Observers.Observer;
import B_DesignPatterns.C_FactoryDesignPattern.Payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    List<Observer> observerList = new ArrayList<>();

    void addObserver(Observer observer){
        observerList.add(observer);
    }

    void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    void notifyObserver(){
        for(Observer observer : observerList){
            observer.update();
        }
    }

    void processPayment(Payment payment){
        payment.pay();
        System.out.println("Processing payment");
        notifyObserver();
    }

}
