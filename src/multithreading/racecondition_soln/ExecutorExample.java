package multithreading.racecondition_soln;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorExample {
    static class Counter{
        AtomicInteger count = new AtomicInteger(0);
        void increment(){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Counter counter = new Counter();
        executor.submit(() -> {

            for (int i = 0; i < 100000; i++){

                counter.increment();

            }

        });

        executor.submit(() -> {

            for (int i = 0; i < 100000; i++){

                counter.increment();

            }

        });

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Final result
        System.out.println("Final Count: " + counter.count.get());

    }
}
