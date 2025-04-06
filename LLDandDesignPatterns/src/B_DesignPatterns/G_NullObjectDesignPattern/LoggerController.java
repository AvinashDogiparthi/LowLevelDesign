package B_DesignPatterns.G_NullObjectDesignPattern;

public class LoggerController {
    public Logger getLogger(String loggerType){
        if(loggerType.equalsIgnoreCase("CONSOLE")){
            return new ConsoleLogger();
        }
        return new NullLogger();
    }
}
