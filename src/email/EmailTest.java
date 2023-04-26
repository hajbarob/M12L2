package email;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EmailTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Email> emails = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            emails.add(new Email("vova" + i + ".hajba@gmail.com", "hi" + i));
        }

        SendgridEmailService sendgridEmailService = new SendgridEmailService();

        List<Future<String>> futures = new ArrayList<>();
        for (Email email : emails) {
            futures.add(sendgridEmailService.send(email));
        }

        System.out.println("Continuing program execution");

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
