package tries;

public class ProducerConsumer {
    int[] array;
    int capacity;
    int size;
    Object lock;
    int head, tail;

    public ProducerConsumer(int capacity){
        this.size= 0;
        this.capacity= capacity ;
        this.array= new int[capacity];
        this.lock = new Object();
        this.head=0;
        this.tail=0;
    }

    public void enQueue(int item) throws InterruptedException {
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

    public int deQueue() throws InterruptedException {
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
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<1000; i++){
                    try {
                        producerConsumer.enQueue(i);
//                        System.out.println("Enqueued Element: " +i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<1000; i++){
                    try {
                        int dequeue = producerConsumer.deQueue();
                        System.out.println("Dequeed Element: "+ dequeue);
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        producer.start();
        Thread.sleep(100);
        consumer.start();
    }
}
