package ShoppingCart;

import java.text.SimpleDateFormat;
import Categories.*;
import User.*;

public class OrderPrinter {
    public static void printOrderAndUserDetails(IOrder order, IUser user) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("----------------------------");
        System.out.println("User Information:");
        System.out.println("UserName: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("----------------------------");

        System.out.println("Order Details:");
        System.out.println("Order Date: " + dateFormat.format(order.getOrderDate()));
        System.out.println("Total Price: $" + order.getTotal());
        System.out.println("Products:");

        for (IProduct product : order.getProducts()) {
            System.out.println(product.getName() + "(s)");
        }
        System.out.println("Thank you for shopping with us!");
    }
}
