package B_DesignPatterns.AA_SingletonDesignPattern.E_BillPugh_Solution;

public class SingletonExample {

    // this will make use of eager initialization but by fixing the object initialization issue

    private SingletonExample() {

    }

    /**
     * Public method to provide access to the Singleton instance.
     * The instance is created and returned by the static nested class.
     *
     * Advantages:
     * - Lazy initialization: The instance is created only when getInstance() is called.
     * - Thread safety: The JVM guarantees thread safety during class loading.
     */
    private static class SingletonExampleHelper{
        private static final SingletonExample INSTANCE_OBJECT = new SingletonExample();
    }

    public static SingletonExample getInstance(){
        return SingletonExampleHelper.INSTANCE_OBJECT;
    }
}
