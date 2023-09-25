package User;

import ShoppingCart.IOrder;

import java.util.List;

public interface IUser {
    String getUsername();

    String getName();

    String getEmail();

    List<IOrder> getOrderHistory();

    void addOrderToHistory(IOrder order);
}
