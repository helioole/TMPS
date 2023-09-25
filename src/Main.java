import java.util.*;
import Categories.*;
import ShoppingCart.*;
import User.*;
import System.*;

public class Main {
    public static void main(String[] args) {
        ECommerceSystem ecommerceSystem = new ECommerceSystem();

        IUser user1 = new User("user1", "Irina R.", "irina@isa.utm.md");

        ecommerceSystem.addUser(user1);

        IProduct product1 = new Clothes("Shirt", 30.0, 50, "Medium");
        IProduct product2 = new Clothes("Jeans", 50.0, 30, "Large");
        IProduct product3 = new Electronics("Laptop", 800.0, 15, "HP");
        IProduct product4 = new Electronics("Tablet", 400.0, 10, "Samsung");

        ecommerceSystem.addProduct("Clothes", product1);
        ecommerceSystem.addProduct("Clothes", product2);
        ecommerceSystem.addProduct("Electronics", product3);
        ecommerceSystem.addProduct("Electronics", product4);

        Scanner scanner = new Scanner(System.in);

        IShoppingCart cart1 = new ShoppingCart();
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Available product categories:");
            List<String> categories = ecommerceSystem.getAllCategories();
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i));
            }

            System.out.print("Select a category (enter the number): ");
            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
                String selectedCategory = categories.get(categoryChoice - 1);

                List<IProduct> productsInCategory = ecommerceSystem.getProductsInCategory(selectedCategory);

                System.out.println("Available products in the selected category:");
                for (int i = 0; i < productsInCategory.size(); i++) {
                    IProduct product = productsInCategory.get(i);
                    if (product instanceof Clothes) {
                        IClothes clothesProduct = (Clothes) product;
                        System.out.println((i + 1) + ". " + clothesProduct.getName() + " - $" + clothesProduct.getPrice() + " (Stock: " + clothesProduct.getStock() + ") "
                                + "Available Size: " + clothesProduct.getSize());
                    } else if (product instanceof Electronics) {
                        IElectronics electronicsProduct = (Electronics) product;
                        System.out.println((i + 1) + ". " + electronicsProduct.getName() + " - $" + electronicsProduct.getPrice() + " (Stock: " + electronicsProduct.getStock() + ") " +
                                " Brand: " + electronicsProduct.getBrand());
                    } else {
                        System.out.println();
                    }
                }

                System.out.print("Select a product to add to the cart (enter the number): ");
                int productChoice = scanner.nextInt();
                scanner.nextLine();

                if (productChoice >= 1 && productChoice <= productsInCategory.size()) {
                    IProduct selectedProduct = productsInCategory.get(productChoice - 1);

                    System.out.print("Enter the quantity to add: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine();

                    if (quantityToAdd > 0 && quantityToAdd <= selectedProduct.getStock()) {
                        cart1.addProduct(selectedProduct, quantityToAdd);
                        System.out.println(quantityToAdd + " " + selectedProduct.getName() + "(s) added to the cart.");
                    } else {
                        System.out.println("Invalid quantity. Please try again.");
                    }

                    System.out.print("Do you want to continue shopping? (yes/no): ");
                    String response = scanner.nextLine().trim().toLowerCase();
                    continueShopping = response.equals("yes");
                } else {
                    System.out.println("Invalid product choice.");
                }
            } else {
                System.out.println("Invalid category choice.");
            }
        }

        ecommerceSystem.placeOrder(user1, cart1);

        User retrievedUser = (User) ecommerceSystem.getUser("user1");

        if (retrievedUser != null && !retrievedUser.getUserHistory().isEmpty()) {
            IOrder latestOrder = retrievedUser.getUserHistory().get(retrievedUser.getUserHistory().size() - 1);
            OrderPrinter.printOrderAndUserDetails(latestOrder, retrievedUser);

        } else {
            System.out.println("No orders placed yet or user not found.");
        }
        scanner.close();
    }
}