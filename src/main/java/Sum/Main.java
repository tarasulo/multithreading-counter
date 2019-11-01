package Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static final int CAPACITY = 1000000;
    private static final int THREADS = 10;
    private static final int RANGE = CAPACITY / THREADS;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            numbers.add((int) (Math.random() * 100));
        }

        executorServiceSum(numbers);
        forkSum(numbers);
    }

    private static void executorServiceSum(List<Integer> numbers)
            throws ExecutionException, InterruptedException {
        System.out.println(" ExecutorService starting work");
        int sum = 0;
        int index = RANGE;
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            List<Integer> subList = numbers.subList(index - RANGE, index);
            Future<Integer> partOfSum = executorService
                    .submit(new SumByExecutor(subList));
            index += RANGE;
            sum += partOfSum.get();
        }
        executorService.shutdown();
        System.out.println("Sum of numbers using ExecutorService = " + sum);
    }

    private static void forkSum(List<Integer> numbers) {
        System.out.println(" ForkJoin starting work");
        int sum = 0;
        int index = RANGE;
        for (int i = 0; i < THREADS; i++) {
            List<Integer> subList = numbers.subList(index - RANGE, index);
            SumByForkJoin sumByForkJoin = new SumByForkJoin(subList);
            Integer partOfSum = new ForkJoinPool().invoke(sumByForkJoin);
            sum += partOfSum;
            index += RANGE;
        }
        System.out.println("Sum of numbers using ForkJoin = " + sum);
    }

}
