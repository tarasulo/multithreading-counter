public class Counter {
    private static int counter = 0;

    public int count(){
        while (counter <100) {
            counter++;
        }
        return counter;
    }
}
