package lab2_new.factory;

import lab2_new.client.*;
import lab2_new.enum_class.CoffeeType;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO:
                return new Espresso();
            case LATTE:
                return new Latte();
            case CAPPUCCINO:
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Invalid coffee type: " + type);
        }
    }
}
