package lab2_old.ShoppingCart;

import java.util.List;

public interface IHistory {
    List<IOrder> getUserHistory();

    void addUserToHistory(IOrder order);
}
