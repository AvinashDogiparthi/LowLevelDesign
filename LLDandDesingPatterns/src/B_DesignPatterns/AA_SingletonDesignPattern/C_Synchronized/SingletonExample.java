package B_DesignPatterns.AA_SingletonDesignPattern.C_Synchronized;

public class SingletonExample {

    private static SingletonExample instance;

    private SingletonExample(){

    }

    public synchronized static SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }

        return instance;
    }

    // Disadvantage:
    // Marking this method as synchronized ensures thread safety, but it introduces a performance bottleneck.
    // When multiple threads try to access this method simultaneously, they are forced to wait,
    // leading to increased waiting time and reduced efficiency.
}
