import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScedulerTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

//        service.schedule(
//                () -> System.out.println("in scedule"),
//                2,
//                TimeUnit.SECONDS);

        //scheduleAtFixeDelay відлік часу починається тільки після того як завершилась попердня задача
        service.scheduleAtFixedRate( //відлік часу починається відразу як попердня задача почала виконання
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("in scheduleAtFixedRate");
                },
                2,
                2,
                TimeUnit.SECONDS
        );
    }
}
