package task;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static final Singleton INSTANCE = new Singleton();
    private int value;

    private Singleton() {}

    public static Singleton getSingleton() {
        return INSTANCE;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "value=" + value + ", " + "hashcode=" + hashCode() +
                '}';
    }
}
