package CA_ProducerConsumerDesign;

public class Producer implements Runnable{

    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true){
            try {
//                System.out.println("Currently running thread :"+Thread.currentThread().getName());
                sharedResource.produceItem();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
