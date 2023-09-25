package ShoppingCart;

import Categories.IProduct;

import java.util.Date;
import java.util.List;

public class Order implements IOrder {
    private List<IProduct> products;
    private double total;
    private Date orderDate;

    public Order(List<IProduct> products, double total) {
        this.products = products;
        this.total = total;
        this.orderDate = new Date();
    }

    public List<IProduct> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
