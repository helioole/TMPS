package User;

import ShoppingCart.IOrder;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String username;
    private String name;
    private String email;

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
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

}
