package multithreading.countdownlatch_cyclicbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerLatch implements Runnable{

    private int id;
    private CountDownLatch countDownLatch;

    public WorkerLatch(int id, CountDownLatch countDownLatch){

        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        doWork();
        countDownLatch.countDown();
    }

    private void doWork() {
        try {
            System.out.println("Thread id: "+ id+" starts working...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i<5; i++){
            service.execute(new WorkerLatch(i, countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks have been finished.");
        service.shutdown();
    }
}
