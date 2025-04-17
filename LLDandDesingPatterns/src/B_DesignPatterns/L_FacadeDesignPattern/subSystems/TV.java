package B_DesignPatterns.L_FacadeDesignPattern.subSystems;

public class TV {

    public void turnOn(){
        System.out.println("Turing on TV");
    }

    public void turfOff(){
        System.out.println("Turing off TV");
    }

    public void setInput(String input){
        System.out.println("TV input set to " + input);
    }
}
