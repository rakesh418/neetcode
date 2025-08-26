package thread;

public class PrintNumSeqThreeThread {
    public volatile static int count=1;

    public synchronized void print(int num, int limit) throws InterruptedException {
        while(count<limit){
            while(count%3!=num){
                wait();
            }
            System.out.println(Thread.currentThread().getName() + ": "+count);
            count++;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintNumSeqThreeThread printNumSeqThreeThread = new PrintNumSeqThreeThread();
        Thread t1 = new Thread(()-> {
            try {
                printNumSeqThreeThread.print(1,10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread1");
        Thread t2 = new Thread(()-> {
            try {
                printNumSeqThreeThread.print(2,10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread2");
        Thread t3 = new Thread(()-> {
            try {
                printNumSeqThreeThread.print(0,10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
