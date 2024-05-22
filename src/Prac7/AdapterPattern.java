package Prac7;

class Adaptee {
    public void specificRequest() {
        System.out.println("Specific request");
    }
}

interface Target {
    void request();
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}