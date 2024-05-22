package Prac5;

public class SingletonP {
    private static SingletonP instance;

    SingletonP() {
    }

    static {
        instance = new SingletonP();
    }

    public static SingletonP getInstance() {
        return instance;
    }
}
