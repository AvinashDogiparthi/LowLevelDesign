package B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors;

public class InfoLogProcessor extends LogProcessor{

    public boolean canHandle(String level){
        if (level.equalsIgnoreCase("INFO")) {
            return true;
        }
        return false;
    }

    public void write(String message){
        System.out.println("INFO : "+message);
    }

}
