import java.util.concurrent.Callable;

public class SumCallable implements Callable<Long> {

    private long a, b;

    public SumCallable(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Long call() throws Exception {
        Thread.sleep(500);
        return a + b;
    }
}
