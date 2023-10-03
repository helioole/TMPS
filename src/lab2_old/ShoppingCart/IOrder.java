package lab2_old.ShoppingCart;

import lab2_old.Categories.IProduct;

import java.util.Date;
import java.util.List;

public interface IOrder {
    List<IProduct> getProducts();

    double getTotal();

    Date getOrderDate();

}
