package src.main.java.sum_machine;

import java.util.HashMap;

import src.main.java.sum_machine.Filter;

//Лучше добавить метод для валидации аргументов в интерфейс фильтра.
//Да. И для каждого фильтра своя реализация будет.
//Чтобы не копипастить один и тот же код парсинга списка целых чисел,
//Можно сделать этот метод  в синглтоне с фильтрами. И его прокинуть в метод для каждого из существующих фильтров при их создании
//

public class FilterList {
    private static HashMap<String, Filter> filters = null;

    private FilterList() {
    }

    // Зачем включать в API списка фильтров метод для парсинга интов (который используется только в фильтрах)?
    private static int[] parseIntegerArguments(String argsLine) {
        // Your code here
        return null;
    }

    private static void fillFilters() {
        filters = new HashMap<String, Filter>();

        filters.put("NDVB", new Filter() {
            @Override
            public boolean isValid(int compared, int source) {
                return compared % source != 0;
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