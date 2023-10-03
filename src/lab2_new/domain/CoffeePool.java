package lab2_new.domain;

import lab2_new.client.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeePool {
    private static CoffeePool instance;
    private List<Coffee> pool = new ArrayList<>();

    private CoffeePool() {
        for (int i = 0; i < 5; i++) {
            pool.add(new Coffee());
        }
    }

    public static CoffeePool getInstance() {
        if (instance == null) {
            instance = new CoffeePool();
        }
        return instance;
    }

    public Coffee borrowCoffee() {
        if (pool.isEmpty()) {
            pool.add(new Coffee());
        }
        Coffee coffee = pool.remove(0);
        coffee.prepare();
        return coffee;
    }

    public void returnCoffee(Coffee coffee) {
        pool.add(coffee);
    }
}