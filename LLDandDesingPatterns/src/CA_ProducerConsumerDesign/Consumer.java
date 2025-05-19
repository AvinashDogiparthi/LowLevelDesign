package CA_ProducerConsumerDesign;

public class Consumer implements Runnable{

    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true){
            try {
//                System.out.println("Currently running thread :"+Thread.currentThread().getName());
                sharedResource.consumeItem();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
