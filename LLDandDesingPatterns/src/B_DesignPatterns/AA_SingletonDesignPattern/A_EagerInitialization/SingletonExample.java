package B_DesignPatterns.AA_SingletonDesignPattern.A_EagerInitialization;

public class SingletonExample {

    // Static instance variable ensures a single instance of the class is created and shared across all objects.
    private static SingletonExample instance = new SingletonExample();

    private SingletonExample(){

    }

    public static SingletonExample getInstance(){
        return instance;
    }

    // Disadvantage:
   // The static instance is created as soon as the application starts,
   // which means memory is allocated even if the getInstance() method is never called.
}
