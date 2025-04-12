package LoggerDesign;

public class Main {
    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getInstance();
        loggerService.process(LoggerEnum.INFO,"please process INFO log",LoggerEnum.FILE);
        loggerService.process(LoggerEnum.FATAL,"please process FATAL log",LoggerEnum.DB);
    }
}
