import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //new Thread(() -> System.out.println("in thread")).start();
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        test3();

    }

    public static void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new PrintRunnable(Integer.valueOf(i)));
        }
    }

    public static void test2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new PrintRunnable(Integer.valueOf(i))));
        }

        while (true) {
            long count = futures.stream().filter(Future::isDone).count();
            System.out.println("count of executed threads = " + count);

            Thread.sleep(500);

            if(count == 10) {
                System.exit(0);
            }
        }
    }

    public static void test3() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new SumCallable(Integer.valueOf(i), Integer.valueOf(i))));
        }

        while (true) {
            long count = futures.stream().filter(Future::isDone).count();
            System.out.println("count of executed threads = " + count);

            Thread.sleep(500);

            if(count == 10) {
                for (Future f : futures) {
                    System.out.println(f.get());
                }
                System.exit(0);
            }
        }
    }
}
