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