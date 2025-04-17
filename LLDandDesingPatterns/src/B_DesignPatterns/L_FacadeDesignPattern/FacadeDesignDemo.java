package B_DesignPatterns.L_FacadeDesignPattern;

import B_DesignPatterns.L_FacadeDesignPattern.subSystems.Lights;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.SoundSystem;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.StreamingDevice;
import B_DesignPatterns.L_FacadeDesignPattern.subSystems.TV;

public class FacadeDesignDemo {

    public static void main(String[] args) {

        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        StreamingDevice streamingDevice = new StreamingDevice();
        Lights lights = new Lights();

        //FACADE
        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(tv,soundSystem,streamingDevice,lights);

        homeTheatreFacade.watchMovie("Netflix");

        System.out.println("\n-- Later --\n");

        // Ending the movie session
        homeTheatreFacade.endMovie();

        // Direct use of subsystems (optional)
        System.out.println("\n-- Direct subsystem use --\n");
        tv.turnOn();
        tv.setInput("HDMI2"); // For gaming
    }
}
