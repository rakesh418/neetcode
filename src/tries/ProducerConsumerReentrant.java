package tries;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReentrant {
    int[] array;
    int capacity;
    int size;
    int head, tail;
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty= lock.newCondition();

    public ProducerConsumerReentrant(int capacity){
        this.size= 0;
        this.capacity= capacity ;
        this.array= new int[capacity];
        this.head=0;
        this.tail=0;
    }

    public  void enQueue(int item) throws InterruptedException {
        lock.lock();
        try{
            while(size==capacity){
                notFull.await();
            }
            array[tail]=item;
            tail = (tail+1)%capacity;
            size++;
            notEmpty.signalAll();
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }finally {
            lock.unlock();
        }
    }

    public  int deQueue() throws InterruptedException {
        lock.lock();
        try {
            while(size==0){
                notEmpty.await();
            }

            int deQueueElement = array[head];
            head= (head+1)%capacity;
            size--;
            notFull.signalAll();
            return deQueueElement;
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }finally {
            lock.unlock();
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerReentrant producerConsumer = new ProducerConsumerReentrant(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ExecutorCompletionService<Integer> s = new ExecutorCompletionService<>(executorService);



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
        executorService.shutdown();
    }
}
