package email;

public class Email {

    private String to;
    private String message;


    public Email(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
