package B_DesignPatterns.E_ChainResponsibilityDesignPattern;

import B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors.DebugLogProcessor;
import B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors.ErrorLogProcessor;
import B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors.InfoLogProcessor;
import B_DesignPatterns.E_ChainResponsibilityDesignPattern.LogProcessors.LogProcessor;

public class Main {
    public static void main(String[] args) {
        InfoLogProcessor infoLogProcessor = new InfoLogProcessor();
        DebugLogProcessor debugLogProcessor = new DebugLogProcessor();
        ErrorLogProcessor errorLogProcessor = new ErrorLogProcessor();

        infoLogProcessor.setNextLogProcessor(debugLogProcessor);
        debugLogProcessor.setNextLogProcessor(errorLogProcessor);

        infoLogProcessor.logMessage(LogProcessor.INFO, "Application started");
        infoLogProcessor.logMessage(LogProcessor.DEBUG, "Fetching user data");
        infoLogProcessor.logMessage(LogProcessor.ERROR, "Null pointer exception occurred");
    }
}
