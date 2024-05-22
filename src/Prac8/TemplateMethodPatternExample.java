package Prac8;

abstract class AbstractClass {
    public final void templateMethod() {
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
    }

    protected void stepOne() {
        System.out.println("Выполняется шаг 1");
    }

    protected abstract void stepTwo();

    protected abstract void stepThree();

    protected void stepFour() {
        System.out.println("Выполняется шаг 4");
    }
}

class ConcreteClass1 extends AbstractClass {
    @Override
    protected void stepTwo() {
        System.out.println("Выполняется шаг 2 для ConcreteClass1");
    }

    @Override
    protected void stepThree() {
        System.out.println("Выполняется шаг 3 для ConcreteClass1");
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    protected void stepTwo() {
        System.out.println("Выполняется шаг 2 для ConcreteClass2");
    }

    @Override
    protected void stepThree() {
        System.out.println("Выполняется шаг 3 для ConcreteClass2");
    }
}

public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        AbstractClass abstractClass1 = new ConcreteClass1();
        abstractClass1.templateMethod();

        AbstractClass abstractClass2 = new ConcreteClass2();
        abstractClass2.templateMethod();
    }
}
