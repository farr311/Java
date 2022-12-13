package lesson22;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class CustomStringBuilder implements Iterable<Character> {

    private final char[] arr;

    public CustomStringBuilder() {
        arr = new char[0];
    }

    public CustomStringBuilder(String s) {
        arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
    }

    public String toString() {
        return String.valueOf(arr);
    }

    public char charAt(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }

    public CustomStringBuilder append(String s) {
        return new CustomStringBuilder(String.valueOf(arr) + s);
    }

    public CustomStringBuilder append(char c) {
        return new CustomStringBuilder(String.valueOf(arr) + c);
    }

    @NotNull
    @Override
    public Iterator<Character> iterator() {
        return new CustomStringIterator(arr);
    }

    private static class CustomStringIterator implements Iterator<Character> {
        private final char[] arr;
        private int index = 0;

        public CustomStringIterator(char[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public Character next() {
            return arr[index++];
        }
    }
}
