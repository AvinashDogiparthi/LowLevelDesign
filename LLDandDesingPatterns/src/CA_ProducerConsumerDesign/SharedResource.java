package CA_ProducerConsumerDesign;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> dequeue = new LinkedList<>();

    public synchronized void produceItem(){

        if(dequeue.size() == 5){
            try{
                System.out.println("SharedResource::produceItem -- producing will be waiting since dequeue size is : "+dequeue.size());
                wait();
            } catch (Exception e){
                // catching if ay exception occurs
            }
        }

        System.out.println("SharedResource::produceItem -- producing a item since dequeue is not full");
        dequeue.add(1);
        notifyAll();
    }

    public synchronized void consumeItem(){

        if(dequeue.isEmpty()){
            try{
                wait();
            } catch (Exception e){
                // catching if ay exception occurs
            }
        }

        System.out.println("SharedResource::consumeItem -- Since queue is not empty, we are consuming one");
        dequeue.poll();
        System.out.println("SharedResource::consumeItem -- after consuming item, now de-queue size had become : "+ dequeue.size());
        notifyAll();
    }
}
