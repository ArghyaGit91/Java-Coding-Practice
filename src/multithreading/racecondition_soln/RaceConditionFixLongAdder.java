package multithreading.racecondition_soln;

import java.util.concurrent.atomic.LongAdder;

public class RaceConditionFixLongAdder {

    static class Counter{
        LongAdder count = new LongAdder();
        void increment(){
            count.increment();
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


        System.out.println("Final Count LongAdder: " + counter.count.sum());
    }
}
