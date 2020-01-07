package singletons;

public enum Singleton {
    INSTANCE;

    int value;

    Singleton() {}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());

    }
}
