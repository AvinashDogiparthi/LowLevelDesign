package B_DesignPatterns.AA_SingletonDesignPattern.D_DoubleLock;

public class SingletonExample {

    private static volatile SingletonExample instance = null;

    private SingletonExample(){

    }

    public static SingletonExample getInstance(){
        if(instance == null){
            synchronized (SingletonExample.class){
                if(instance == null){
                    instance = new SingletonExample();
                }
            }
        }

        return instance;
    }

    // The 'volatile' keyword ensures that changes to the 'instance' variable
    // are visible to all threads immediately. Without 'volatile', threads
    // may cache the value of 'instance' locally, leading to unstable data.

    // Disadvantages :
    // Since we are not using cache here and writing instance object directly to memory
    // this could slow up our processing time
}
