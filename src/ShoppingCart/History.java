package ShoppingCart;

import ShoppingCart.IOrder;
import java.util.ArrayList;
import java.util.List;

public class History implements IHistory {
    private List<IOrder> userHistory;

    public History() {
        this.userHistory = new ArrayList<>();
    }

    public List<IOrder> getUserHistory() {
        return userHistory;
    }

    public void addUserToHistory(IOrder order) {
        userHistory.add(order);
    }
}
