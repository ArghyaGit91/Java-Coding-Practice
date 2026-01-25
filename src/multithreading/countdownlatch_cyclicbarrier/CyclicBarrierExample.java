package multithreading.countdownlatch_cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerBarrier implements Runnable{

    private int id;
    private Random random;
    CyclicBarrier cyclicBarrier;

    public WorkerBarrier(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        doWork();
    }

    private void doWork() {
        try {
            System.out.println("Thread id: "+ id+" starts working...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After the await...");
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks have been finished.");
            }
        });

        for (int i = 0; i<5; i++){
            service.execute(new WorkerBarrier(i+1, barrier));
        }

        service.shutdown();
    }
}
