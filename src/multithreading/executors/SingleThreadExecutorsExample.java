package multithreading.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SingleThreadTask implements Runnable{

    private int id;
    public SingleThreadTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id: "+id+" is in work - thread id: "
                +Thread.currentThread().getName());
        long duration = (long) Math.random()*5;
        try {
//            TimeUnit.SECONDS.sleep(duration);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SingleThreadExecutorsExample {
    public static void main(String[] args) {

        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            for (int i = 0; i<25; i++){
                executorService.execute(new SingleThreadTask(i+1));
            }

//            to stop the executor
            executorService.shutdown();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
