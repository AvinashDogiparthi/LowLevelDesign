package LoggerDesign.LogWriter;

public class DBWriter implements LogWriter{
    @Override
    public void push(String message) {
        System.out.println("DBWriter :: push - pushing message " + message + " to DB");
    }
}
