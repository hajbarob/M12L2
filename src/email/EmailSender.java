package email;

import java.util.concurrent.Callable;

public class EmailSender implements Callable {

    private Email email;

    public EmailSender(Email email) {
        this.email = email;
    }

    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(email);
        return "email with content =\"" + email.getMessage() + "\" sended";
    }
}
