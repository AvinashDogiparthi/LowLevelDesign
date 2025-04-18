package B_DesignPatterns.M_BridgeDesignPattern.Remote;

import B_DesignPatterns.M_BridgeDesignPattern.TV.TV;

public class AdvancedRemote extends Remote{

    public AdvancedRemote(TV tv) {
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
