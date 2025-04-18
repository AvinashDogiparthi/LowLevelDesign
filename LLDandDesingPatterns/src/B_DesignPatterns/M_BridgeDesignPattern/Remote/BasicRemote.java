package B_DesignPatterns.M_BridgeDesignPattern.Remote;

import B_DesignPatterns.M_BridgeDesignPattern.TV.TV;

public class BasicRemote extends Remote{

    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    public void turnOff() {
        tv.turnOff();
    }

    @Override
    public void turnOn() {
        tv.turnOn();
    }

    @Override
    public void increaseVolume() {
        tv.increaseVolume();
    }
}
