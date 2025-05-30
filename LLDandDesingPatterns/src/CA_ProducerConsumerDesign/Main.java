package CA_ProducerConsumerDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
