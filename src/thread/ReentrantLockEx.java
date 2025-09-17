package thread;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            try{
                lock.lock();
                System.out.println("Thread T1 acquired lock, Holding");
                Thread.sleep(50000);
            }catch(InterruptedException e){
                System.out.println("Thread t1 interrupted");
            }finally {
                if(lock.isHeldByCurrentThread()) lock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try{
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("Thread T2 interrupted");
            }finally {
                if(lock.isHeldByCurrentThread()) lock.unlock();
            }
        });
        t1.start();
        Thread.sleep(500);
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        t1.interrupt();

        SoftReference<String> softRef = new SoftReference<>(new String("Hello"));
        SoftReference<LinkedList<String>> softRef1 = new SoftReference<>(new LinkedList<String>());
    }
}
