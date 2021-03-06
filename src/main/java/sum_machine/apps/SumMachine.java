package src.main.java.sum_machine.apps;

import java.util.HashMap;

import src.main.java.sum_machine.io.Input;
import src.main.java.sum_machine.io.Output;
import src.main.java.sum_machine.filters.FilterList;
import src.main.java.sum_machine.filters.Filter;

public class SumMachine implements Application {
    private Input input;
    private Output output;
    private SumMachineStore store;
    private HashMap<String, Filter> filters;

    private SumMachine inputFilter() throws Exception {
        this.output.outFormat("@ Enter filter : ");
        String filterName = this.input.next();

        boolean filterExists = this.filters.containsKey(filterName);
        if (!filterExists) {
            throw new Exception("This filter doesn't exist");
        }
        this.store.setFilter(this.filters.get(filterName));

        return this;
    }

    private SumMachine inputFilterArgs() {
        Filter filter = this.store.getFilter();
        String rawArgs = this.input.nextLine().trim();
        filter.useArgs(rawArgs);
        return this;
    }

    private SumMachine inputNumbersCount() {
        this.output.outFormat("@ Enter amount of numbers: ");
        int numbersCount = this.input.nextInt();
        this.store.setNumbers(new int[numbersCount]);
        return this;
    }

    private SumMachine inputNumbers() {
        this.output.outFormat("@ Enter numbers: ");

        int[] numbers = this.store.getNumbers();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = this.input.nextInt();
        }

        return this;
    }


    private SumMachine calculateSum() {
        int sum = 0;
        int[] numbers = this.store.getNumbers();
        Filter filter = this.store.getFilter();
        for (int i = 0; i < numbers.length; i++) {
            if (filter.isValid(numbers[i])) {
                sum += numbers[i];
            }
        }
        this.store.setSum(sum);
        return this;
    }

    private SumMachine outputSum() {
        int sum = this.store.getSum();

        this.output.outFormat("Resulting sum is: %d\n", sum);

        return this;
    }

    public SumMachine(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.store = new SumMachineStore();
        this.filters = FilterList.get();
    } 

    @Override
    public void run() {
        try {
            this.inputFilter()
                    .inputFilterArgs()
                    .inputNumbersCount()
                    .inputNumbers()
                    .calculateSum()
                    .outputSum();
        } catch (Exception error) {
            this.output.output(error.getMessage());
        }
    }

    @Override
    public boolean killsFlow() {
        return false;
    }
}

class SumMachineStore {
    private Filter filter;
    private int[] numbers;
    private int sum;

    public Filter getFilter() {
        return this.filter;
    }

    public SumMachineStore setFilter(Filter filter) {
        this.filter = filter;
        return this;

    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public SumMachineStore setNumbers(int[] numbers) {
        this.numbers = numbers;
        return this;
    }

    public int getSum() {
        return this.sum;
    }

    public SumMachineStore setSum(int sum) {
        this.sum = sum;
        return this;
    }
}

