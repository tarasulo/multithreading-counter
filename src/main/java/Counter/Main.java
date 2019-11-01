package Counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadA threadA = new ThreadA(counter);
        Thread threadB = new Thread(new ThreadB(counter));
        threadA.start();
        threadB.start();
    }
}
