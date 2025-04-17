package B_DesignPatterns.L_FacadeDesignPattern.subSystems;

public class StreamingDevice {
    public void turnOn() {
        System.out.println("Streaming Device is ON");
    }

    public void turnOff() {
        System.out.println("Streaming Device is OFF");
    }

    public void selectApp(String appName) {
        System.out.println("Selected app: " + appName);
    }
}
