package lab2_old.Builders;
import lab2_old.Categories.*;
public class ProductBuilder<T extends ProductBuilder<T>> {
    protected String name;
    protected double price;
    protected int stock;

    public T withName(String name) {
        this.name = name;
        return self();
    }

    public T withPrice(double price) {
        this.price = price;
        return self();
    }

    public T withStock(int stock) {
        this.stock = stock;
        return self();
    }

    protected T self() {
        return (T) this;
    }

    public Product build() {
        return new Product(name, price, stock);
    }
}
