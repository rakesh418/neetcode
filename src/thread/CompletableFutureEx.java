package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        List<CompletableFuture<String>> futures = new ArrayList<>();

        for(int i=0; i<5; i++){
            final int id = i;
            futures.add(CompletableFuture.supplyAsync( ()->{
                try {
                    Thread.sleep((6-id)*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "TaskId: "+id+"completed";
            }, executors));
        }
        while(!futures.isEmpty()){
            CompletableFuture<Object> any = CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0]));
            String result = (String) any.join();
            System.out.println(result);
            futures.removeIf(f->f.isDone() && f.join().equals(result));
        }
        executors.shutdown();
    }
}
