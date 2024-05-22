package Prac7;

interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Выполняется операция в конкретном компоненте");
    }
}

class BaseDecorator implements Component {
    private Component component;

    public BaseDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}


class ExtraFunctionalityDecorator extends BaseDecorator {
    public ExtraFunctionalityDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("Добавлена дополнительная функциональность");
    }
}


class ExtraFunctionalityDecorator2 extends BaseDecorator {
    public ExtraFunctionalityDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("Добавлена еще одна дополнительная функциональность");
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator1 = new ExtraFunctionalityDecorator(component);
        Component decorator2 = new ExtraFunctionalityDecorator2(decorator1);

        decorator2.operation();
    }
}
