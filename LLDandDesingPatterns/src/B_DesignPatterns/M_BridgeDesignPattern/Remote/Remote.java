package B_DesignPatterns.M_BridgeDesignPattern.Remote;

import B_DesignPatterns.M_BridgeDesignPattern.TV.TV;

public abstract class Remote {

    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOff();
    public abstract void turnOn();
    public abstract void increaseVolume();
}
