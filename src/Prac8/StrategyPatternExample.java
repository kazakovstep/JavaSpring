package Prac8;

interface Strategy {
    void execute();
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Выполняется стратегия 1");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Выполняется стратегия 2");
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.execute();
        }
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        Context context = new Context();

        Strategy strategy1 = new ConcreteStrategy1();
        context.setStrategy(strategy1);
        context.executeStrategy();

        Strategy strategy2 = new ConcreteStrategy2();
        context.setStrategy(strategy2);
        context.executeStrategy();
    }
}