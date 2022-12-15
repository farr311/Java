package lesson20;

public final class ImmutableClass {
    private final String val1;
    private final int val2;
    private final boolean val3;

    public ImmutableClass(String val1, int val2, boolean val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    public String getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public boolean isVal3() {
        return val3;
    }
}
