package Prac2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Human human1 = new Human(12, "Kolym", "Zharikov", LocalDate.of(2004, 12, 30), 43);
        Human human2 = new Human(14, "Stepan", "Kazakov", LocalDate.of(2002, 12, 23), 56);
        Human human3 = new Human(23, "Rudo", "Chakr", LocalDate.of(1945, 4, 12), 11);
        Human human4 = new Human(21, "Strong", "VeryStrong", LocalDate.of(2002, 5, 13), 101);


        List<Human> humans = new ArrayList<>();

        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);

        Stream<Human> humanStream = humans.stream();

        long summaryAge = humanStream
                .filter(human -> human.age > 20)
                .sorted(Comparator.comparing(human -> human.firstName.charAt(human.firstName.length() - 1)))
                .peek(human -> {
                    human.age += 3;
                    System.out.println(human);
                })
                .mapToLong(human -> human.age)
                .reduce(0, (a, b) -> a + b);

        Stream<Human> humanStream2 = humans.stream();
        long count = humanStream2
                .filter(human -> human.age > 20)
                .count();

        System.out.println(summaryAge / count);
    }
}
