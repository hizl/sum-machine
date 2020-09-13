package src.main.java.sum_machine.utils;

public class Pair<T0, T1> {
    private T0 item0;
    private T1 item1;

    private Pair() {}

    public Pair(T0 item0, T1 item1) {
        this.item0 = item0;
        this.item1 = item1;
    }

    public T0 get0() {
        return this.item0;
    }

    public T1 get1() {
        return this.item1;
    }
}
