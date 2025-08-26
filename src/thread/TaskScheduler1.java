package thread;

import java.util.concurrent.*;

class MyTask implements Callable {

    int duration;
    MyTask(int duration){
        this.duration = duration;
    }
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(duration*1000);
        return "completed successfully in "+ duration +"seconds";
    }
}

public class TaskScheduler1 {

    public static void checkCompletion(Future<String> task, int time, String taskName) throws ExecutionException, InterruptedException, TimeoutException {
        try {
            String res = task.get(time, TimeUnit.SECONDS);
            System.out.println(taskName + " "+res);
        }catch(TimeoutException e){
            System.out.println(taskName + "timedout ! Cancelling");
            task.cancel(true);
        }
    }


    public static void checkCompletionThroughScheduler(Future<String> task, int timeOutSeconds, String taskName,ScheduledExecutorService scheduler) throws ExecutionException, InterruptedException, TimeoutException {
        scheduler.schedule(()->{
            if(!task.isDone()){
                task.cancel(true);
                System.out.println(taskName + "timedout ! Cancelling");
            }else{
                try {
                    System.out.println(taskName+" result: "+task.get());
                } catch (Exception e) {
                    System.out.println(taskName+" Failed");
                }
            }

        },timeOutSeconds, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        Future<String> task1 = executorService.submit(new MyTask(2));
        Future<String> task2 = executorService.submit(new MyTask(5));

        checkCompletion(task1, 3, "task1");
        checkCompletionThroughScheduler(task1, 5, "task1", scheduler);
        checkCompletionThroughScheduler(task2, 5, "task2",scheduler);

        executorService.shutdown();
        scheduler.shutdown();
    }
}
