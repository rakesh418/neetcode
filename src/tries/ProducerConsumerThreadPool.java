package tries;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerThreadPool {
    int[] array;
    int capacity;
    int size;
    Object lock;
    int head, tail;

    public ProducerConsumerThreadPool(int capacity){
        this.size= 0;
        this.capacity= capacity ;
        this.array= new int[capacity];
        this.lock = new Object();
        this.head=0;
        this.tail=0;
    }

    public  void enQueue(int item) throws InterruptedException {
        synchronized (lock){
            while(size==capacity){
                lock.wait();
            }
            array[tail]=item;
            tail = (tail+1)%capacity;
            size++;
            lock.notifyAll();
        }
    }

    public  int deQueue() throws InterruptedException {
        synchronized (lock){
            while(size==0){
                lock.wait();
            }

            int deQueueElement = array[head];
            head= (head+1)%capacity;
            size--;
            lock.notifyAll();
            return deQueueElement;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerThreadPool producerConsumer = new ProducerConsumerThreadPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        AtomicInteger counter = new AtomicInteger();
        for(int i=0; i<3;i++){
            final int threadId = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j =0; j<1000; j++){
                        try {
                            int element = counter.incrementAndGet();
                            producerConsumer.enQueue(element);
                            System.out.println("Enqueed Element: "+ element+" : thread: "+threadId);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }

        for(int i=0; i<3;i++){
            final int threadId = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j =0; j<1000; j++){
                        try {
                            int dequeue = producerConsumer.deQueue();
                            System.out.println("Dequeed Element: "+ dequeue+" : thread: "+threadId);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }
    }
}
