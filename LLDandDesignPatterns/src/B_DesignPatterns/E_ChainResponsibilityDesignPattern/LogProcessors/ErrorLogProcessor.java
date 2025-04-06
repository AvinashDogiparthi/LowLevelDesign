package B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors;

public class ErrorLogProcessor extends LogProcessor{
    public boolean canHandle(String level){
        if (level.equalsIgnoreCase("ERROR")) {
            return true;
        }
        return false;
    }

    public void write(String message){
        System.out.println("ERROR : "+message);
    }
}
