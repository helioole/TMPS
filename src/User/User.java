package User;

import ShoppingCart.IOrder;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String username;
    private String name;
    private String email;
    private List<IOrder>userHistory;

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.userHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<IOrder> getUserHistory() {
        return userHistory;
    }

    public void addUserToHistory(IOrder order) {
        userHistory.add(order);
    }
}
