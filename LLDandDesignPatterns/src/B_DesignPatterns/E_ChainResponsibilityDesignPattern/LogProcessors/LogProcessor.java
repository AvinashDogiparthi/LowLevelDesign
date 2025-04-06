package B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors;

public abstract class LogProcessor {
    public static final String INFO = "INFO";
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";

    protected LogProcessor nextLogProcessor;

    public void setNextLogProcessor(LogProcessor logProcessor){
        this.nextLogProcessor = logProcessor;
    }

    public void logMessage(String level,String message){
        if(canHandle(level)){
            write(message);
        }

        if(nextLogProcessor != null){
            nextLogProcessor.logMessage(level,message);
        }

    }

    public abstract boolean canHandle(String level);
    public abstract void write(String message);
}
