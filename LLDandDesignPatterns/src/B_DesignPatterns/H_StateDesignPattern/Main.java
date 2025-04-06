package B_DesignPatterns.H_StateDesignPattern;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();

        tv.changeChannel();        // Should say TV is OFF
        tv.pressPowerButton();     // Turning TV ON
        tv.changeChannel();        // Changing channel
        tv.increaseVolume();       // Increasing volume
        tv.pressPowerButton();     // Turning TV OFF
        tv.increaseVolume();       // Should say TV is OFF
    }
}
