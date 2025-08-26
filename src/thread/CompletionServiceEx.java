package thread;

import java.util.concurrent.*;

public class CompletionServiceEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<>(pool);

        // Submit 5 tasks with different durations
        for (int i = 1; i <= 5; i++) {
            final  int  id = i;
            completionService.submit(() -> {
                System.out.println(id);
                Thread.sleep((6 - id) * 1000L); // different sleep times
                return "Task " + id + " completed";
            });
        }

        // Collect results in the order they complete
        for (int i = 0; i < 5; i++) {
            Future<String> future = completionService.take(); // blocks until a task finishes
            System.out.println(future.get());
        }

        pool.shutdown();

    }
}
