package lab2_new;

import lab2_new.builder.CustomCoffeeBuilder;
import lab2_new.client.Coffee;
import lab2_new.domain.CoffeeShop;
import lab2_new.enum_class.CoffeeType;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = CoffeeShop.getInstance();

        coffeeShop.takeOrder("Alice", CoffeeType.ESPRESSO);
        coffeeShop.takeOrder("Bob", CoffeeType.LATTE);

        CustomCoffeeBuilder builder = new CustomCoffeeBuilder(CoffeeType.CAPPUCCINO)
                .addSugar(2)
                .addMilk(true);

        Coffee customCoffee = builder.build();
        customCoffee.serve();
    }
}
