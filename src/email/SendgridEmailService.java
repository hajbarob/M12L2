package email;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SendgridEmailService implements EmailService {

    private ExecutorService sender = Executors.newFixedThreadPool(2);


//    @Override
//    public void send(Email email) throws InterruptedException {
//        Thread.sleep(1000);
//        System.out.println(email);
//    }

//    @Override
//    public Future<String> send(Email email) throws InterruptedException {
//        //todo check if email wants to receive emails
//        return sender.submit(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(email);
//            return "email with content =\"" + email.getMessage() + "\" sended";
//        });
//    }

    @Override
    public Future<String> send(Email email) throws InterruptedException {
        //todo check if email wants to receive emails
        //todo receiver wants to receive emails in current time
        return sender.submit(new EmailSender(email));
    }
}
