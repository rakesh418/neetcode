package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsBlockingQueueEx {
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

    public void produce(int elem) throws InterruptedException {
        System.out.println("produced element :"+ elem);
        blockingQueue.put(elem);
    }

    public void consume() throws InterruptedException {
       int ele = blockingQueue.take();
       System.out.println("Consumed element :"+ ele);
    }

    public static void main(String[] args) {
        ProdConsBlockingQueueEx prodConsBlockingQueueEx = new ProdConsBlockingQueueEx();
        Thread producer = new Thread(() -> {
            int i=0;
            while(true){
                i++;
                try {
                    prodConsBlockingQueueEx.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(true){
                try {
                    prodConsBlockingQueueEx.consume();
//                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
