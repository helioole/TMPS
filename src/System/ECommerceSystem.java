package System;

import java.util.*;
import Categories.*;
import ShoppingCart.*;
import User.IUser;

public class ECommerceSystem {
    private static ECommerceSystem instance;
    private Map<String, IUser> users;
    private Map<String, List<IProduct>> productCategories;
    private List<IOrder> orders;

    public ECommerceSystem() {
        this.users = new HashMap<>();
        this.productCategories = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    public static ECommerceSystem getInstance() {
        if (instance == null) {
            instance = new ECommerceSystem();
        }
        return instance;
    }

    public void addUser(IUser user) {
        users.put(user.getUsername(), user);
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

    public void placeOrder(IHistory history, IShoppingCart cart) {
        double total = cart.calculateTotal();
        List<IProduct> orderedProducts = new ArrayList<>(cart.getItems().keySet());

        IOrder order = new Order(orderedProducts, total);
        orders.add(order);

        for (IProduct product : orderedProducts) {
            int quantity = cart.getItems().get(product);
            product.decreaseStock(quantity);
        }

        history.addUserToHistory(order);
        cart.getItems().clear();
    }
}