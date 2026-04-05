package multithreading.racecondition_soln;

public class RaceConditionFixSynchronize {

    static class Counter{
        int count = 0;
        synchronized void increment(){
            count++;
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


        System.out.println("Final Count: " + counter.count);
    }
}
