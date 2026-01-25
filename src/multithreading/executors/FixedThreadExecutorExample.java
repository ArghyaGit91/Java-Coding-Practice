package multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FixedThreadTask implements Runnable{
    private int id;
    public FixedThreadTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id: "+id+" is in work - thread id: "
                +Thread.currentThread().getName());
        long duration = (long) Math.random()*5;
        try {
            TimeUnit.SECONDS.sleep(duration);
//            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadExecutorExample {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 0; i<100; i++){
                executorService.execute(new FixedThreadTask(i+1));
            }
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                    executorService.shutdown();
                }
            } catch (InterruptedException e) {
                executorService.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
