package Prac6.Builder;

public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildPart1() {
        product.setPart1("Казаков");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Степан");
    }

    @Override
    public void buildPart3() {
        product.setPart3("Сергеевич");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
