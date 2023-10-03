package lab2_old.ShoppingCart;

import java.util.HashMap;
import java.util.Map;
import lab2_old.Categories.IProduct;

public class ShoppingCart implements IShoppingCart {
    private Map<IProduct, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addProduct(IProduct product, int quantity) {
        if (quantity > 0 && product.getStock() >= quantity) {
            int currentQuantity = items.getOrDefault(product, 0);
            items.put(product, currentQuantity + quantity);
        }
    }

    public Map<IProduct, Integer> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<IProduct, Integer> entry : items.entrySet()) {
            IProduct product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
