
package com.company.dev.ar;
import java.util.HashMap;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {


        Input input = new Input() {
            private Scanner scanner = new Scanner(System.in);

            @Override
            public String next() {
                String token = this.scanner.next();

                return token;
            }

            @Override
            public int nextInt() {


                int number = this.scanner.nextInt();
                return number;
            }
        };


        Output output = new Output() {

            @Override
            public void output(String message) {
                System.out.print(message);
            }

            @Override
            public void outFormat(String pattern, Object... args) {
                System.out.printf(pattern, args);
            }
        };

        App application = new App(input, output);

        application.run();
    }
}


class App {
    private Input input;
    private Output output;
    private AppState state;
    private HashMap<String, Filter> filters;


    private App inputFilter() {
        this.output.output("Enter filter with one argument: ");
        String filterName = this.input.next();
        int argument = this.input.nextInt();
        FilterList.checkInputString(filterName);
        FilterList.checkInputInteger(argument);


        this.state.setFilter(this.filters.get(filterName)).setFilterArg(argument);

        return this;
    }

    private App inputNumbersCount() {

        this.output.output("Enter amount of numbers: ");
        int numbersCount = this.input.nextInt();
        FilterList.checkInputInteger(numbersCount);

        this.state.setNumbers(new int[numbersCount]);


        return this;
    }

    private App inputNumbers() {
        this.output.output("Enter numbers: ");


        int[] numbers = this.state.getNumbers();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = this.input.nextInt();
            FilterList.checkInputInteger(numbers[i]);
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
        this.inputFilter().inputNumbersCount().inputNumbers().calculateSum().outputSum();
    }
}


interface Filter {
    boolean isValid(int compared, int source);
}


interface Input {
    public String next();

    public int nextInt();

}

interface Output {
    public void output(String message);

    public void outFormat(String pattern, Object... args);
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
//Лучше добавить метод для валидации аргументов в интерфейс фильтра.
//Да. И для каждого фильтра своя реализация будет.
//Чтобы не копипастить один и тот же код парсинга списка целых чисел,
//Можно сделать этот метод  в синглтоне с фильтрами. И его прокинуть в метод для каждого из существующих фильтров при их создании
//

class FilterList {
    private static HashMap<String, Filter> filters = null;

    private FilterList() {
    }

    public static void checkInputInteger(int number) {
        if (filters.containsValue(Integer.valueOf(number))) {
            throw new IllegalArgumentException("Invalid! There must be a number");
        }
    }

    public static void checkInputString(String string) {
        if (!filters.containsKey(string)) {
            throw new IllegalArgumentException("this filter is not defined ");
        }
    }


    private static void fillFilters() {
        filters = new HashMap<String, Filter>();

        filters.put("NDVB", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared % source == 1;
            }
        });


        filters.put("LESQ", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared <= source;
            }
        });


        filters.put("GRTQ", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared >= source;
            }
        });


        filters.put("LESS", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared < source;
            }
        });
        filters.put("GRT", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared > source;
            }
        });
        filters.put("EQ", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared == source;
            }
        });
        filters.put("DIVB", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared % source == 0;
            }
        });
    }

    public static HashMap<String, Filter> get() {
        if (filters == null) {
            fillFilters();
        }

        return filters;
    }
}

