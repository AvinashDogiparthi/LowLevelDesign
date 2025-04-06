package B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors;

public class DebugLogProcessor extends LogProcessor{
    public boolean canHandle(String level){
        if (level.equalsIgnoreCase("DEBUG")) {
            return true;
        }
        return false;
    }

    public void write(String message){
        System.out.println("DEBUG : "+message);
    }
}
