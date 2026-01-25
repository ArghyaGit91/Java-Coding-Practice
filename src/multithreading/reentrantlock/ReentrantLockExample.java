package multithreading.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Process {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("Running the produce method...");
            condition.await();
            System.out.println("Again acquired produce method...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }


    }

    public void consume() throws InterruptedException {
        try {
            Thread.sleep(2000);
            lock.lock();
            System.out.println("Consume method is executed");
            Thread.sleep(5000);
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }


    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {

        Process process = new Process();

        Thread t1 = new Thread(() -> {
            try {
                process.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                process.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
