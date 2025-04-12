package LoggerDesign.LogWriter;

public class ConsoleWriter implements LogWriter{

    @Override
    public void push(String message) {
        System.out.println("ConsoleWriter :: push - pushing message " + message + " to a Console");
    }
}
