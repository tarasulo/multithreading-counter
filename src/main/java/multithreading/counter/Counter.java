package multithreading.counter;

public class Counter {
    private int counter = 0;

    public int count() {
        return counter++;
    }

    public int getCount() {
        return counter;
    }
}
