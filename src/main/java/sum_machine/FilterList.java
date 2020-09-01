package src.main.java.sum_machine;

import java.math.BigInteger;
import java.util.HashMap;

public class FilterList {
    private static HashMap<String, Filter<Integer>> filters = null;

    FilterList() {
    }

    protected static int[] parseIntegerArguments(String argsLine) {
        return null;
    }


    private static void fillFilters() {
        filters = new HashMap<String, Filter<Integer>>();

        filters.put("ISPRM", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                BigInteger bigInteger = BigInteger.valueOf(compared);
                boolean probablePrime;
                return probablePrime = bigInteger.isProbablePrime((int) Math.log(compared));
            }
        });


        filters.put("NDVB", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared % sourceArgs != 0;
            }
        });


        filters.put("LESQ", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared <= sourceArgs;
            }
        });


        filters.put("GRTQ", new Filter<Integer>() {

            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared >= (int) sourceArgs;
            }
        });


        filters.put("LESS", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }


            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared < (int) sourceArgs;
            }
        });
        filters.put("GRT", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared > sourceArgs;
            }
        });
        filters.put("EQ", new Filter<Integer>() {
            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared == sourceArgs;
            }
        });
        filters.put("DIVB", new Filter<Integer>() {

            @Override
            public Integer parseArgs(String argsLine) {
                return null;
            }

            @Override
            public boolean isValid(int compared, Integer sourceArgs) {
                return compared % sourceArgs == 0;
            }
        });
    }

    public static HashMap<String, Filter<Integer>> get() {

        if (filters == null) {
            fillFilters();
        }

        return filters;
    }


}