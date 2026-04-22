package multithreading;

public class WaitBlockedDemo {
    static Object lock =  new Object();

    public static void main(String[] args){
        Thread t1 = new Thread(() ->{
            synchronized (lock){
                try {
                    System.out.println("T1 got lock");

                    lock.wait();

                    System.out.println("T1 resumed");
                }catch (Exception e){}
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                System.out.println("T2 got lock");
                lock.notify();
                System.out.println("T2 notified");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T2 leaving lock");

            }
        });

        t1.start();

        try{ Thread.sleep(2000);}catch(Exception e){}

        t2.start();
    }
}
