package src.main.java.sum_machine;

import java.util.HashMap;

import src.main.java.sum_machine.Input;
import src.main.java.sum_machine.Output;
import src.main.java.sum_machine.FilterList;

public class App {
    private Input input;
    private Output output;
    private AppState state;
    private HashMap<String, Filter<Integer>> filters;

    private App inputFilter() throws Exception {
        this.output.output("Enter filter : ");
        String filterName = this.input.nextLine();

        if (filterName.endsWith(" ")) {
            output.output("write argument : ");
        }else {
            boolean filterExists = this.filters.containsKey(filterName);
            if (!filterExists) {
                throw new Exception("This filter doesn't exist ");
            }
        }


            int argument = this.input.nextInt();
            this.state.setFilter(this.filters.get(filterName)).setFilterArg(argument);


        return this;
    }


    private App inputNumbersCount() {
        this.output.output("Enter amount of numbers: ");
        int numbersCount = this.input.nextInt();
        this.state.setNumbers(new int[numbersCount]);
        return this;
    }

    private App inputNumbers() {
        this.output.output("Enter numbers: ");

        int[] numbers = this.state.getNumbers();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = this.input.nextInt();
        }

        return this;
    }

    private App calculateSum() {
        int sum = 0;

        int[] numbers = this.state.getNumbers();
        Filter filter = this.state.getFilter();
        int filterArgument = this.state.getFilterArg();

        for (int i = 0; i < numbers.length; i++) {
            if (filter.isValid(numbers[i], filterArgument)) {
                sum += numbers[i];
            }
        }

        this.state.setSum(sum);

        return this;
    }

    private App outputSum() {
        int sum = this.state.getSum();

        this.output.outFormat("Resulting sum is: %d\n", sum);

        return this;
    }

    public App(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.state = new AppState();
        this.filters = FilterList.get();
    }

    public void run() {
        try {
            this.inputFilter().inputNumbersCount().inputNumbers().calculateSum().outputSum();
        } catch (Exception error) {
            this.output.output(error.getMessage());
        }
    }
}

class AppState {
    private Filter filter;
    private int filterArg;
    private int[] numbers;
    private int sum;

    public Filter getFilter() {
        return this.filter;
    }

    public AppState setFilter(Filter filter) {
        this.filter = filter;
        return this;

    }

    public int getFilterArg() {
        return this.filterArg;
    }

    public AppState setFilterArg(int filterArg) {
        this.filterArg = filterArg;
        return this;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public AppState setNumbers(int[] numbers) {
        this.numbers = numbers;
        return this;
    }

    public int getSum() {
        return this.sum;
    }

    public AppState setSum(int sum) {
        this.sum = sum;
        return this;
    }
}

