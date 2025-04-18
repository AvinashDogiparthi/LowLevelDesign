package B_DesignPatterns.M_BridgeDesignPattern.TV;

public class SonyTV implements TV{
    @Override
    public void turnOff() {
        System.out.println("Turning OFF Sony TV");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON Sony TV");
    }

    @Override
    public void increaseVolume() {
        System.out.println("Increasing volume for Sony TV");
    }
}
