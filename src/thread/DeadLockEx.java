package thread;
//Always acquired locks in the same order
public class DeadLockEx {
    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    public void method1(){
        synchronized(lock1){
            System.out.println("lock1 captured under method 1");
            synchronized (lock2){
                System.out.println("lock2 captured under method 1");
            }
        }
    }

    public void method2(){
        synchronized(lock2){    //lock1 fix
            System.out.println("lock2 captured under method 2");
            synchronized (lock2){   //lock2 fix
                System.out.println("lock1 captured under method 2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockEx deadLockEx = new DeadLockEx();
        Thread t1 = new Thread(()-> deadLockEx.method1());
        Thread t2 = new Thread(()-> deadLockEx.method2());
        t1.start();
        t2.start();
    }
}
