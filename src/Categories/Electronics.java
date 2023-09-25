package Categories;

import java.util.ArrayList;
import java.util.List;

public class Electronics extends Product implements IElectronics{
    private String brand;
    private static List<Electronics> items = new ArrayList<>();

    public Electronics(String name, double price, int stock, String brand) {
        super(name, price, stock);
        this.brand = brand;
        items.add(this);
    }

    public String getBrand() {
        return brand;
    }

    public static List<Electronics> getItems() {
        return items;
    }
}
