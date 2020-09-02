package src.main.java.sum_machine;

import java.math.BigInteger;
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

            // Попробуй без библиотечных методов написать проверку на простоту числа)
            @Override
            public boolean isValid(int compared, Object sourceArgs) {

                return false;
            }
        });

        filters.put("IBND", new Filter<Pair<Integer, Integer>>() {
            @Override
            protected Pair<Integer, Integer> parseArgs(String argsLine) {
                Scanner scanner = new Scanner(argsLine);

                // Дальше сам попробуй тянуть аргументы)

                return null;
            }

            @Override
            public boolean isValid(int compared, Pair<Integer, Integer> sourceArgs) {

                return false;
            }
        });

        filters.put("ISSUM", new Filter<int[]>() {
            @Override
            protected int[] parseArgs(String argsLine) {
                Scanner scanner = new Scanner(argsLine);

                // Дальше сам попробуй тянуть аргументы)

                return null;
            }

            @Override
            public boolean isValid(int compared, int[] sourceArgs) {

                return false;
            }
        })

        filters.put("NDVB", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared % sourceArgs != 0;
            }
        });


        filters.put("LESQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared <= sourceArgs;
            }
        });


        filters.put("GRTQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared >= sourceArgs;
            }
        });


        filters.put("LESS", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }


            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared < sourceArgs;
            }
        });

        filters.put("GRT", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared > sourceArgs;
            }
        });

        filters.put("EQ", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared == sourceArgs;
            }
        });

        filters.put("DIVB", new Filter<Integer>() {
            @Override
            protected Integer parseArgs(String argsLine) {
                Integer arg = Integer.parseInt(argsLine);
                return arg;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared % sourceArgs == 0;
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