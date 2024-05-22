package Prac3;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Semaphore semaphore = new Semaphore(1);
    private static volatile My_structures structures = new My_structures();

    public static void add_with_semaphore(int value) {
        try {
            semaphore.acquire();
            if (!structures.my_list.isEmpty()) {
                int last_value = structures.my_list.get(structures.my_list.size() - 1);
                structures.my_list.add(last_value + value);
            } else {
                structures.my_list.add(value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static synchronized void add_with_synchronized(int key, int value) {
        if (structures.my_map.containsKey(key)) {
            int last_value = structures.my_map.get(key);
            structures.my_map.put(key, last_value + value);
        } else {
            structures.my_map.put(key, value);
        }
    }

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                add_with_semaphore(1);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                add_with_semaphore(1);
            }
            System.out.println(structures.my_list);
        });

        Thread tree = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                add_with_synchronized(i, 1);
            }
        });

        Thread four = new Thread(() -> {
            for (int i = 6; i < 12; i++) {
                add_with_synchronized(i, 2);
            }
            System.out.println(structures.my_map);
        });

        one.start();
        two.start();
        tree.start();
        four.start();
    }
}