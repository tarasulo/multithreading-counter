public class ThreadB implements Runnable {
    private Counter counter;

    public ThreadB(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            System.out.println("ThreadB " + counter.count());
        }
    }
}
