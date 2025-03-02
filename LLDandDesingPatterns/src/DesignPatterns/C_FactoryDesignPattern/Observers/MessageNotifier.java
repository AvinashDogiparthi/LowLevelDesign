package DesignPatterns.C_FactoryDesignPattern.Observers;

public class MessageNotifier implements Observer {

    @Override
    public void update(){
        System.out.println("Notifying end user using message");
    }
}
