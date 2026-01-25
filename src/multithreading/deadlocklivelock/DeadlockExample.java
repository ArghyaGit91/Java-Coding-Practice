package multithreading.deadlocklivelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        DeadlockExample deadlockExample = new DeadlockExample();
        Thread thread1 = new Thread(()->{

            deadlockExample.worker1();
        });
        Thread thread2 = new Thread(deadlockExample::worker2);

        thread1.start();
        thread2.start();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires Lock1...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker1 acquired Lock2...");
        lock1.unlock();
        lock2.unlock();
    }
    public void worker2() {
//        cyclic dependency
//        lock2.lock();
        lock1.lock();
        System.out.println("Worker2 acquires Lock1...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        lock1.lock();
        lock2.lock();
        System.out.println("Worker2 acquired Lock2...");
        lock2.unlock();
        lock1.unlock();
    }
}


