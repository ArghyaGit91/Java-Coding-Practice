package multithreading.racecondition_soln;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionFixAtomicInteger {

    static class Counter{
        AtomicInteger count = new AtomicInteger(0);
        void increment(){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws Exception{

        Counter counter = new Counter();

        Thread t1 = new Thread(() ->{
            System.out.println("Thread Name: "+Thread.currentThread().getName());
            for (int i = 0; i < 100000; i++){
                counter.increment();
            }
        });

        Thread t2 = new Thread(() ->{
            System.out.println("Thread Name: "+Thread.currentThread().getName());
            for (int i = 0; i < 100000; i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Final Count: " + counter.count.get());
    }
}
