package LoggerDesign;

import LoggerDesign.LogWriter.LogWriter;
import LoggerDesign.Logger.*;

public class LoggerService {

    private Logger fatalLogger;
    private Logger debugLogger;
    private Logger infoLogger;
    private Logger warningLogger;
    private Logger errorLogger;

    private static LoggerService instance = null;

    public static LoggerService getInstance(){
        if(instance == null){
            instance = new LoggerService();
            return instance;
        }
        return instance;
    }

    private LoggerService(){
        fatalLogger =  new FatalLogger(null);
        errorLogger = new ErrorLogger(fatalLogger);
        warningLogger =  new WarningLogger(errorLogger);
        infoLogger =  new InfoLogger(warningLogger);
        debugLogger =  new DebugLogger(infoLogger);
    }

    public void process(LoggerEnum type, String message, LoggerEnum pushType){
        System.out.println("Logging process started");
        debugLogger.printLog(type,message);
        LogWriter logWriter = WriterFactory.getLogWriter(pushType);
        logWriter.push(message);
    }

}
