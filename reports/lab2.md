# Laboratory Work Nr.2

### Course: Software Design Techniques and Mechanisms
### Topic: Creational Design Patterns
### Author: Racovcena Irina
### Group: FAF-212

------
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Design patterns used in this laboratory work:

* Singleton
* Builder
* Object Pooling
* Factory Method

## Implementation

### Singleton

Signleton design pattern ensures that there is only one instance of the `CoffeeShop` throughout the project.
Achieved by making the constructor private and providing a `getInstance` method to obtain the single instance.

Example:
```java
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
```

## Object Pooling

Manages a pool of `Coffee` objects to efficiently reuse coffee resources.
The pool is initialized with a set number of coffee instances, and these instances are borrowed and returned when customers place orders.
Coffee instances are prepared and served, and then they are returned to the pool for reuse.

Example:

```java
public class CoffeePool {
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
```

## Factory Method

Implemented in `CoffeeFactory` class and provides a factory method `createCoffee` to create different types of coffee based on the specified `CoffeeType`.
This pattern allows for the creation of various coffee types without exposing the creation logic to the client code.

Example:

```java
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
                throw new IllegalArgumentException("Invalid coffee type: ");
        }
    }
}
```

## Builder

Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
In my case it is implemented in `CustomCoffeeBuilder` and allows clients to build custom coffee orders with specific options.
Clients can specify the type of coffee, the amount of sugar, and whether milk should be added.
The builder then creates a custom coffee order based on these options.

Example:

```java
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
```

Conclusion:

In conclusion, creational design patterns offer essential tools for tackling the challenges associated with object creation and initialization in software development.
This project taught me that creational design patterns play a fundamental role in ensuring that object creation is efficient, flexible, and maintainable



