package multithreading.daemonthreadexplain;

class WorkerThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Worker thread finishes execution");
    }

}

class DaemonThread implements Runnable{

    @Override
    public void run() {

        try {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Daemon thread is running:");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {

        Thread dt = new Thread(new DaemonThread());
        dt.setDaemon(true);
        dt.start();

        Thread wt = new Thread(new WorkerThread());
        wt.start();
    }
}
