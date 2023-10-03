# Laboratory Work Nr.1

### Course: Software Design Techniques and Mechanisms
### Topic: SOLID Principles
### Author: Racovcena Irina
### Group: FAF-212

----

## Table of Contents

- [Theory](#theory)
- [Objectives](#objectives)
- [SOLID Principles](#solid-principles)
    - [Single Responsibility Principle](#single-responsibility-principle-srp)
    - [Open-Closed Principle](#openclosed-principle-ocp)
    - [Liskov Substitution Principle](#liskov-substitution-principle-lsp)
    - [Interface Segregation Principle](#interface-segregation-principle-isp)
    - [Dependency Inversion Principle](#dependency-inversion-principle-dip)
- [Conclusion](#conclusion)

---

## Theory
SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle,
and Dependency Inversion Principle. Each principle addresses 
a specific aspect of software design, such as the organization of 
responsibilities, the handling of dependencies, and the design of interfaces. 
By following these principles, software developers can create more modular, 
testable, and reusable code that is easier to modify and extend over time. 
These principles are widely accepted and adopted in the software development 
community and can be applied to any object-oriented programming language.

## Objectives:

1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).
2. Select a domain area for the sample project.
3. Define the main involved classes and think about what instantiation mechanisms are needed.
4. Respect SOLID Principles in your project.

## SOLID Principles

### Single Responsibility Principle
Single-responsibility Principle (SRP) states:

A class should have one and only one reason to change, meaning that a class should have only one job.

Following this principles each of my classes has their own job and their responsibilities 
do not coincide. For instance, class `OrderPrinter` only prints all the details related to the
order:

```java
public class OrderPrinter {
    public static void printOrderAndUserDetails(IOrder order, IUser user) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        lab2_old.Builders.System.out.println("----------------------------");
        lab2_old.Builders.System.out.println("lab2_old.Builders.User Information:");
        lab2_old.Builders.System.out.println("UserName: " + user.getName());
        lab2_old.Builders.System.out.println("Username: " + user.getUsername());
        lab2_old.Builders.System.out.println("Email: " + user.getEmail());
        lab2_old.Builders.System.out.println("----------------------------");

        lab2_old.Builders.System.out.println("Order Details:");
        lab2_old.Builders.System.out.println("Order Date: " + dateFormat.format(order.getOrderDate()));
        lab2_old.Builders.System.out.println("Total Price: $" + order.getTotal());
        lab2_old.Builders.System.out.println("Products:");

        for (IProduct product : order.getProducts()) {
            lab2_old.Builders.System.out.println(product.getName());
        }
        lab2_old.Builders.System.out.println("Thank you for shopping with us!");
    }
}
```

### Open-Closed Principle

Open-closed Principle (OCP) states:

Objects or entities should be open for extension but closed for modification.

This means that a class should be extendable without modifying the class itself

In our case we have class `Product` and we don't need to modify it in order to 
add more types of products, we simply can create new types of categories and 
as many products as we want:

```java
public class Product implements IProduct {
  ...
}

```

```java
public class Clothes extends Product implements IClothes{
    
}
```
```java
public class Electronics extends Product implements IElectronics{
  ...
}
```

### Liskov Substitution Principle (LSP)

Liskov Substitution Principle states:

Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

This means that every subclass or derived class should be substitutable for their base or parent class.

We can use the previous code for an example to show how this principle works. I don't need to
add `name`, `price` and `stock` for `Electronics` and `Clothes`, instead I can use all methods
and attributes from their parent and add new ones specific for this exact methods, `size` and
`brand` in my case:

```java
public class Product implements IProduct {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
        }
    }
}
```

```java
public class Clothes extends Product implements IClothes{
    private String size;

    public Clothes(String name, double price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
```

### Interface Segregation Principle

Interface segregation principle states:

A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

Classes in this project implement only interfaces that describe their behavior:

```java
public class lab2_old.Builders.ShoppingCart implements IShoppingCart {
    private Map<IProduct, Integer> items;

    public lab2_old.Builders.ShoppingCart() {
      ...
    }

    public void addProduct(IProduct product, int quantity) {
      ...
    }

    public Map<IProduct, Integer> getItems() {
      ...
    }

    public double calculateTotal() {
      ...
    }
}
```
```java
public interface IShoppingCart {
    void addProduct(IProduct product, int quantity);

    Map<IProduct, Integer> getItems();

    double calculateTotal();
}
```

### Dependency Inversion Principle

Dependency inversion principle states:

Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.

Example of DIP:
```java
public class ECommerceSystem {
    
  ...

  public void placeOrder(IUser user, IShoppingCart cart) {
    double total = cart.calculateTotal();
    List<IProduct> orderedProducts = new ArrayList<>(cart.getItems().keySet());

    IOrder order = new Order(orderedProducts, total);
    orders.add(order);

    for (IProduct product : orderedProducts) {
      int quantity = cart.getItems().get(product);
      product.decreaseStock(quantity);
    }

    user.addUserToHistory(order);
    cart.getItems().clear();
  }
}
```

Conclusion:

In this laboratory work I implemented SOLID principles on practice. 
They serve as a guide to creating 
software that's easier to maintain, extend, and understand. 
By following these principles, we're better equipped to build 
robust and efficient software systems.




