package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsSequential {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        for(int i=0; i<10;i++){
            final int taskId =i;
            executors.submit(()->{
                System.out.println("Task"+ taskId +" is running on "+ Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " finished");
            });
        }

        executors.shutdown();
    }
}
