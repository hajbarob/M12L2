public class PrintRunnable implements Runnable{

    private Object o;

    public PrintRunnable(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        System.out.println(o);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
