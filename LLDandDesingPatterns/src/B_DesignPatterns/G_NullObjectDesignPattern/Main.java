package B_DesignPatterns.G_NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        LoggerController loggerController = new LoggerController();
        Logger logger = loggerController.getLogger("CONSOLE");
        logger.log("This is a console logger");

        Logger logger1 = loggerController.getLogger("IDKWHATITIS");
        logger1.log("This log should not print as it routes to null logger");
    }
}
