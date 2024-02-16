package Prac1;

public class Main {

    @FunctionalInterface
    public interface Comparator<T> {
        boolean compare(T o1, T o2);
    }

    public static void main(String[] args) {
        int[] array1 = {10, 20, 30, 45, 67};
        int[] array2 = {11, 12, 13,123,123,123,1,3};

        Comparator<int[]>comparator = (o1,o2) -> (o1.length > o2.length);

        if(comparator.compare(array1, array2)){
            System.out.println("Первый массив больше!");
        } else {
            System.out.println("Второй массив больше!");
        }
    }
}