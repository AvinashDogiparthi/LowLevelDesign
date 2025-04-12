package LoggerDesign;

import LoggerDesign.LogWriter.ConsoleWriter;
import LoggerDesign.LogWriter.DBWriter;
import LoggerDesign.LogWriter.FileWriter;
import LoggerDesign.LogWriter.LogWriter;

public class WriterFactory {
    public static LogWriter getLogWriter(LoggerEnum type){
        if(type == LoggerEnum.FILE){
            return new FileWriter();
        } else if ( type == LoggerEnum.DB){
            return new DBWriter();
        } else if ( type == LoggerEnum.CONSOLE){
            return new ConsoleWriter();
        }
        return null;
    }
}
