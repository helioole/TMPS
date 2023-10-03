package lab2_new.builder;

import lab2_new.client.Coffee;

import lab2_new.enum_class.CoffeeType;
import lab2_new.factory.CoffeeFactory;

public class CustomCoffeeBuilder {
    private CoffeeType type;
    private int sugar = 0;
    private boolean milk = false;

    public CustomCoffeeBuilder(CoffeeType type) {
        this.type = type;
    }

    public CustomCoffeeBuilder addSugar(int sugar) {
        this.sugar = sugar;
        return this;
    }

    public CustomCoffeeBuilder addMilk(boolean milk) {
        this.milk = milk;
        return this;
    }

    public Coffee build() {
        return new Coffee();
    }
}
