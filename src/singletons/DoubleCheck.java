package singletons;

public class DoubleCheck {

    private static volatile DoubleCheck instance;
    private DoubleCheck() {}

    public DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
