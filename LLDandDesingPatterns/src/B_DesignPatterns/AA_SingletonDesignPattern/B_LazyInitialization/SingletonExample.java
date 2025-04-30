package B_DesignPatterns.AA_SingletonDesignPattern.B_LazyInitialization;

public class SingletonExample {

    private static SingletonExample instance;

    private SingletonExample(){

    }

    public static SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }

        return instance;
    }

     // Disadvantage :
     // When two threads try to access the getInstance() method at the same time,
     // Since the instance is null for both threads, two separate objects may be created,
     // breaking the Singleton pattern and leading to inconsistent behavior.
}
