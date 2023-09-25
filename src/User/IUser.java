package User;

import ShoppingCart.IOrder;

import java.util.List;

public interface IUser {
    String getUsername();

    String getName();

    String getEmail();

    List<IOrder> getUserHistory();

    void addUserToHistory(IOrder order);
}
