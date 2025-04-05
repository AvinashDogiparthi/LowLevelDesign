package B_DesignPatterns.G_NullObjectDesignPattern;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String message){
        System.out.println("Log : "+message);
    }
}
