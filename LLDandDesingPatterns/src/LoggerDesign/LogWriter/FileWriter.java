package LoggerDesign.LogWriter;

public class FileWriter implements LogWriter{
    @Override
    public void push(String message) {
        System.out.println("FileWriter :: push - pushing message " + message + " to a File");
    }
}
