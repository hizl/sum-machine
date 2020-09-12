package src.main.java.sum_machine.filters;


import java.util.HashMap;
import java.util.Scanner;


import src.main.java.sum_machine.filters.Filter;
import src.main.java.sum_machine.utils.Pair;

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

                Pair<Integer, Integer> args = new Pair<Integer, Integer>(
                    scanner.nextInt(),
                    scanner.nextInt()
                );

                return args;
            }

            @Override
            public boolean isValid(int compared) {
                int lowerBound = this.args.get0() <= this.args.get1() ? 
                    this.args.get0() : 
                    this.args.get1();

                int upperBound = this.args.get0() <= this.args.get1() ?
                    this.args.get1() :
                    this.args.get0();

                return (lowerBound <= compared) && (compared <= upperBound);
            }
        });

        filters.put("ISSUM", new Filter<int[]>() {
            private int sum = 0;

            private int calculateSum() {
                int result = 0;

                for (int i = 0; i < this.args.length; i++) {
                    result += this.args[i];
                }

                return result;
             }

            @Override
            public Filter<int[]> useArgs(String argsLine) {
                super.useArgs(argsLine);
                this.sum = this.calculateSum();
                return this;
            }


            @Override
            public boolean isValid(int compared) {
                return compared == this.sum;
            }


            @Override
            protected int[] parseArgs(String argsLine) {
                String[] rawArgs = argsLine.split(" ");
                int[] result = new int[rawArgs.length];

                for (int i = 0; i < rawArgs.length; i++) {
                    result[i] = Integer.parseInt(rawArgs[i]);
                }

                return result;
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