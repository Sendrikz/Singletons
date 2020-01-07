package task;

import java.io.Serializable;

public class ProtectedSingleton implements Serializable, Cloneable {

    private static final ProtectedSingleton INSTANCE = new ProtectedSingleton();
    private int value;

    private ProtectedSingleton() {}

    public static ProtectedSingleton getSingleton() {
        return INSTANCE;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Solve for serialization
    protected Object readResolve() {
        return INSTANCE;
    }

    // Solve for cloning
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // throw new CloneNotSupportedException();
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "ProtectedSingleton{" +
                "value=" + value + ", " + "hashcode=" + hashCode() +
                '}';
    }
}
