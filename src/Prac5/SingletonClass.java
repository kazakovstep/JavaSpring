package Prac5;

public class SingletonClass {
    private SingletonClass instance;

    public synchronized SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
            return instance;
        }
        return instance;
    }
}
