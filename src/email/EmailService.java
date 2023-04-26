package email;

import java.util.concurrent.Future;

public interface EmailService {

    Future<String> send(Email email) throws InterruptedException;
}
