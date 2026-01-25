package multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable{

    @Override
    public void run() {
        System.out.println("Updating and downloading stock related data from web...");
    }
}

public class ScheduledExecutorExample {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 5000, TimeUnit.MILLISECONDS);
    }
}
