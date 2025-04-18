package B_DesignPatterns.M_BridgeDesignPattern;


import B_DesignPatterns.M_BridgeDesignPattern.Remote.BasicRemote;
import B_DesignPatterns.M_BridgeDesignPattern.Remote.Remote;
import B_DesignPatterns.M_BridgeDesignPattern.TV.SamsungTV;
import B_DesignPatterns.M_BridgeDesignPattern.TV.SonyTV;
import B_DesignPatterns.M_BridgeDesignPattern.TV.TV;

public class BridgePatternDemo {
    public static void main(String[] args) {
        TV sony = new SonyTV();
        TV samsung = new SamsungTV();


        Remote sonyBasicRemote = new BasicRemote(sony);
        Remote samsungBasicRemote = new BasicRemote(samsung);

        System.out.println("Using Sony TV:");
        sonyBasicRemote.turnOn();
        sonyBasicRemote.turnOff();

        System.out.println("\nUsing Samsung TV:");
        samsungBasicRemote.turnOn();
        samsungBasicRemote.turnOff();
    }
}
