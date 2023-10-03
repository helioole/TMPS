package lab2_old.ShoppingCart;

import java.util.Map;
import lab2_old.Categories.IProduct;

public interface IShoppingCart {
    void addProduct(IProduct product, int quantity);

    Map<IProduct, Integer> getItems();

    double calculateTotal();
}
