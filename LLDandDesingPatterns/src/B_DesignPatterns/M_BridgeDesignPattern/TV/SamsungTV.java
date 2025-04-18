package B_DesignPatterns.M_BridgeDesignPattern.TV;

public class SamsungTV implements TV{

    @Override
    public void turnOff() {
        System.out.println("Turning OFF Samsung TV");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON Samsung TV");
    }

    @Override
    public void increaseVolume() {
        System.out.println("Increasing volume for Samsung TV");
    }
}
