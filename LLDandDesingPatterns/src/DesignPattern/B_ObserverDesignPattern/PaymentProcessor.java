package DesignPattern.B_ObserverDesignPattern;

import DesignPattern.B_ObserverDesignPattern.Observers.Observer;
import DesignPattern.B_ObserverDesignPattern.Payment.Payment;

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
