package DesignPattern.C_FactoryDesignPattern.Observers;

public class EmailNotifier implements Observer {
    @Override
    public void update(){
        System.out.println("Notifying end user through email");
    }
}
