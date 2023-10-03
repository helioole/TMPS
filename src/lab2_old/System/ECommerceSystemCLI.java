package lab2_old.System;

import lab2_old.Categories.*;
import lab2_old.Builders.ClothesBuilder;
import lab2_old.Builders.ElectronicsBuilder;
import lab2_old.ShoppingCart.*;
import lab2_old.User.IUser;
import lab2_old.Builders.UserBuilder;

import java.util.List;
import java.util.Scanner;

public class ECommerceSystemCLI {
    private ECommerceSystem ecommerceSystem;
    private Scanner scanner;

    public ECommerceSystemCLI() {
        ecommerceSystem = ECommerceSystem.getInstance();
        scanner = new Scanner(System.in);
    }

    public void run() {
        IUser user1 = new UserBuilder()
                .setUsername("user1")
                .setName("Irina R.")
                .setEmail("irina@isa.utm.md")
                .build();

        ecommerceSystem.addUser(user1);

        IClothes product1 = new ClothesBuilder()
                .withName("T-shirt")
                .withPrice(19)
                .withStock(50)
                .withSize("M")
                .withFabric("Cotton")
                .build();

        IClothes product2 = new ClothesBuilder()
                .withName("Pants")
                .withPrice(29)
                .withStock(20)
                .withSize("L")
                .withFabric("Jeans")
                .build();

        IElectronics product3 = new ElectronicsBuilder()
                .withName("Laptop")
                .withPrice(1099)
                .withStock(10)
                .withBrand("Apple")
                .withModel("Macbook Air")
                .withWarrantyInYears(2)
                .build();

        IElectronics product4 = new ElectronicsBuilder()
                .withName("Phone")
                .withPrice(799)
                .withStock(15)
                .withBrand("Apple")
                .withModel("iPhone 14")
                .withWarrantyInYears(2)
                .build();

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
                                + "Available Size: " + clothesProduct.getSize() + " Fabric: " + clothesProduct.getFabric());
                    } else if (product instanceof Electronics) {
                        IElectronics electronicsProduct = (Electronics) product;
                        System.out.println((i + 1) + ". " + electronicsProduct.getName() + " - $" + electronicsProduct.getPrice() + " (Stock: " + electronicsProduct.getStock() + ") " +
                                " Brand: " + electronicsProduct.getBrand() + " Model: " + electronicsProduct.getModel() + " Warranty: " + electronicsProduct.getWarrantyInYears() + " years");
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

        IHistory history = new History();

        ecommerceSystem.placeOrder(history, cart1);


        if (history != null && !history.getUserHistory().isEmpty()) {
            IOrder latestOrder = history.getUserHistory().get(history.getUserHistory().size() - 1);
            OrderPrinter.printOrderAndUserDetails(latestOrder, user1);

        } else {
            System.out.println("No orders placed yet or user not found.");
        }
        scanner.close();
    }
}

