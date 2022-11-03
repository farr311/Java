package lesson11;

public class Stack <E> {

    private Object[] array;
    private int capacity = 16;
    private int size = 0;

    private final double GROWTH_THRESHOLD = .75;
    private final int GROWTH_FACTOR = 2;


    public Stack() {
        array = new Object[this.capacity];
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new Object[this.capacity];
    }

    public void push(E e) {
        if (size >= array.length * GROWTH_THRESHOLD) {
            increaseCapacity();
        }
        array[size++] = e;
    }

    public E pop() {
        E element = (E) array[--size];
        array[size + 1] = null;

        return element;
    }

    public E peek() {
        return (E) array[size - 1];
    }

    public int size() {
        return this.size;
    }

    private void increaseCapacity() {
        capacity *= GROWTH_FACTOR;
        Object[] copy = new Object[capacity];
        System.arraycopy(this.array, 0, copy, 0, this.array.length);
        array = copy;
    }
}
