package multithreading.threadcommunication;



public class SynchronizationExample {

    public static int counter = 0;

    public static synchronized void increment(){
        counter++;
    }
//    public static void increment(){
//        counter++;
//    }
    public static void process(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; ++i){
                    increment();
                }
            }
        });



        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 200; i++) {
                increment();
            }
        });

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter: "+counter);
    }

    public static void main(String[] args) {

        process();

    }
}
