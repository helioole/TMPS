package System;

import java.util.*;
import Categories.*;
import ShoppingCart.IOrder;
import ShoppingCart.IShoppingCart;
import ShoppingCart.Order;
import User.IUser;

public class ECommerceSystem {
    private Map<String, IUser> users;
    private Map<String, List<IProduct>> productCategories;
    private List<IOrder> orders;

    public ECommerceSystem() {
        this.users = new HashMap<>();
        this.productCategories = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    public void addUser(IUser user) {
        users.put(user.getUsername(), user);
    }

    public IUser getUser(String username) {
        return users.get(username);
    }

    public void addProduct(String category, IProduct product) {
        if (!productCategories.containsKey(category)) {
            productCategories.put(category, new ArrayList<>());
        }
        productCategories.get(category).add(product);
    }

    public List<String> getAllCategories() {
        return new ArrayList<>(productCategories.keySet());
    }

    public List<IProduct> getProductsInCategory(String category) {
        return productCategories.getOrDefault(category, Collections.emptyList());
    }

    public void placeOrder(IUser user, IShoppingCart cart) {
        double total = cart.calculateTotal();
        List<IProduct> orderedProducts = new ArrayList<>(cart.getItems().keySet());

        IOrder order = new Order(orderedProducts, total);
        orders.add(order);

        for (IProduct product : orderedProducts) {
            int quantity = cart.getItems().get(product);
            product.decreaseStock(quantity);
        }

        user.addOrderToHistory(order);
        cart.getItems().clear();
    }
}
