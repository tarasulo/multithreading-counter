public class ThreadA extends Thread {
    private Counter counter;

    public ThreadA(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            System.out.println("ThreadA " + counter.count());
        }
    }
}
