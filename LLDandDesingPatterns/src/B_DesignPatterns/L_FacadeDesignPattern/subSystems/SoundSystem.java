package B_DesignPatterns.L_FacadeDesignPattern.subSystems;

public class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is ON");
    }

    public void turnOff() {
        System.out.println("Sound System is OFF");
    }

    public void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
}
