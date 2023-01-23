package lesson29.homework;

public class Promise<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public boolean hasValue() {
        return value != null;
    }

    void setValue(T value) {
        this.value = value;
    }
}
