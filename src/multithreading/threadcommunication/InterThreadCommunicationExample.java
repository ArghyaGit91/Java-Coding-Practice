package multithreading.threadcommunication;

class Process {

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again acquired produce method...");
        }
    }
    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Consume method is executed");
            notify();
            Thread.sleep(5000);

        }
    }
}

public class InterThreadCommunicationExample {
    public static void main(String[] args) {

        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
    }
}
