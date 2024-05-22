package Prac5;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        SingletonClass singletonc = new SingletonClass();
        SingletonP singletonP = new SingletonP();
        System.out.println(singletonP);
    }
}
