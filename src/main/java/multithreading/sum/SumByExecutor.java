package multithreading.sum;

import java.util.List;
import java.util.concurrent.Callable;

public class SumByExecutor implements Callable<Integer> {
    private List<Integer> numbers;
    private int sum = 0;

    public SumByExecutor(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
