package multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "id: "+id;
    }
}

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future<String> future = service.submit(new Processor(i+1));
            futureList.add(future);
        }

        for (Future<String> f: futureList){

            System.out.println(f.get());
        }

        service.shutdown();
    }
}
