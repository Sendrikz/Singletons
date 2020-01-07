package singletons;

import java.io.Serializable;

public class SimpleSingleton implements Serializable {

    private static final SimpleSingleton INSTANCE = new SimpleSingleton();
    private int value;

    private SimpleSingleton() {}

    public static SimpleSingleton getSingleton() {
        return INSTANCE;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SimpleSingleton{" +
                "value=" + value +
                '}';
    }
}
