package DesignPatterns.B_ObserverDesignPattern.Observers;

public class MessageNotifier implements Observer{

    @Override
    public void update(){
        System.out.println("Notifying end user using message");
    }
}
