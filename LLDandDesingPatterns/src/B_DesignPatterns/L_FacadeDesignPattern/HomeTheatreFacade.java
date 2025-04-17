package B_DesignPatterns.L_FacadeDesignPattern;

import B_DesignPatterns.L_FacadeDesignPattern.subSystems.Lights;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.SoundSystem;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.StreamingDevice;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.TV;

public class HomeTheatreFacade {
    private TV tv;
    private SoundSystem soundSystem;
    private StreamingDevice streamingDevice;
    private Lights lights;

    public HomeTheatreFacade(TV tv, SoundSystem soundSystem, StreamingDevice streamingDevice, Lights lights) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.streamingDevice = streamingDevice;
        this.lights = lights;
    }

    public void watchMovie(String app) {
        System.out.println("=== Setting up movie mode ===");
        lights.dim();
        tv.turnOn();
        tv.setInput("HDMI1");
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        streamingDevice.turnOn();
        streamingDevice.selectApp(app);
        System.out.println("Enjoy your movie! 🍿");
    }

    public void endMovie() {
        System.out.println("=== Shutting down movie mode ===");
        streamingDevice.turnOff();
        soundSystem.turnOff();
        tv.turfOff();
        lights.brighten();
    }
}
