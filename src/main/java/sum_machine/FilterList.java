package src.main.java.sum_machine;


import java.util.HashMap;
import java.util.Scanner;


import src.main.java.sum_machine.Filter;
import src.main.java.sum_machine.Pair;

public class FilterList {
    private static HashMap<String, Filter> filters = null;

    private FilterList() {
    }


    private static void fillFilters() {
        filters = new HashMap<String, Filter>();


        filters.put("ISPRM", new Filter() {
            @Override
            protected Object parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared) {
                if (compared < 2) return false;
                long upperBound = Math.round(Math.sqrt((double) compared));
                for (long i = 2; i <= upperBound; i++) {
                    if (compared % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        });


        filters.put("IBND", new Filter<Pair<Integer, Integer>>() {
            @Override

            protected Pair<Integer, Integer> parseArgs(String argsLine) {
                Scanner scanner = new Scanner(argsLine);


                return null;
            }

            @Override
            public boolean isValid(int compared) {
                return true;
            }
        });

        filters.put("ISSUM", new Filter<int[]>() {


            @Override
            public Filter<int[]> useArgs(String argsLine) {
                Scanner scanner = new Scanner(argsLine);
                int i;
                int sum;
                String sumArgument = "";
                int[] numbersArray = new int[2];
                String parseString = scanner.nextLine();
                String[] stringArray = parseString.split(" ");
                for (i = 0; i < stringArray.length; i++) {
                    numbersArray[i] = Integer.parseInt(stringArray[i]);
                    int number = numbersArray[0];
                    int number2 = numbersArray[1];
                    sum = number + number2;
                    sumArgument = String.valueOf(sum);
                }
                return super.useArgs(sumArgument);
            }


            @Override
            public boolean isValid(int compared) {
                String parseInt = String.valueOf(compared);
                Filter<int[]> sumNumbers = useArgs(parseInt);
                if (sumNumbers.equals(compared)) {
                    return true;
                }
                return false;
            }


            @Override
            protected int[] parseArgs(String argsLine) {
                Scanner scanner = new Scanner(argsLine);
                int[] numbersArray = new int[1];
                String parseString = scanner.nextLine();
                String[] stringArray = parseString.split(" ");
                for (int i = 0; i < stringArray.length; i++) {
                    numbersArray[i] = Integer.parseInt(stringArray[i]);

                }
                return numbersArray;
            }
        });


        filters.put("NDVB", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared % this.args != 0;
            }
        });


        filters.put("LESQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared <= this.args;
            }
        });


        filters.put("GRTQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared >= this.args;
            }
        });


        filters.put("LESS", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }


            @Override
            public boolean isValid(int compared) {
                return compared < this.args;
            }
        });

        filters.put("GRT", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared > this.args;
            }
        });

        filters.put("EQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared == this.args;
            }
        });

        filters.put("DIVB", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared) {
                return compared % this.args == 0;
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