package Prac6.Builder;

public class Product {
    private String part1;  
    private String part2;  
    private String part3;  
  
    public void setPart1(String part1) {  
        this.part1 = part1;  
    }  
  
    public void setPart2(String part2) {  
        this.part2 = part2;  
    }  
  
    public void setPart3(String part3) {  
        this.part3 = part3;  
    }  
  
    public void show() {  
        System.out.println("Состав:");
        System.out.println("Часть 1: " + part1);
        System.out.println("Часть 2: " + part2);
        System.out.println("Часть 3: " + part3);
    }  
}

