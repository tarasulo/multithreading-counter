package Sum;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumByForkJoin extends RecursiveTask<Integer> {
    private List<Integer> numbers;
    private int sum = 0;

    public SumByForkJoin(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public SumByForkJoin() {

    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName());
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
