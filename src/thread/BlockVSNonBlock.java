package thread;

import java.util.concurrent.*;

public class BlockVSNonBlock {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        Future<String> future1 = executors.submit(()->{
            try {
                Thread.sleep(4000);
                return "Task1";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<String> future2 = executors.submit(()->{
            try {
                Thread.sleep(2000);
                return "Task2";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            System.out.println(future1.get(2, TimeUnit.SECONDS));
            System.out.println(future2.get());
        }finally {
            executors.shutdown();
        }
    }
}
