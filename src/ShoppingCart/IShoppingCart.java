package ShoppingCart;

import java.util.Map;
import Categories.IProduct;

public interface IShoppingCart {
    void addProduct(IProduct product, int quantity);

    Map<IProduct, Integer> getItems();

    double calculateTotal();
}
