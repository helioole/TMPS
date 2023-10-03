package lab2_new.domain;

import lab2_new.client.Coffee;
import lab2_new.enum_class.CoffeeType;

public class CoffeeShop {
    private static CoffeeShop instance;

    private CoffeeShop() {
    }

    public static CoffeeShop getInstance() {
        if (instance == null) {
            instance = new CoffeeShop();
        }
        return instance;
    }

    public void takeOrder(String customerName, CoffeeType coffeeType) {
        Coffee coffee = CoffeePool.getInstance().borrowCoffee();
        System.out.println(customerName + " ordered a " + coffeeType.toString() + " coffee.");
        coffee.prepare();
        coffee.serve();
        CoffeePool.getInstance().returnCoffee(coffee);
    }
}
