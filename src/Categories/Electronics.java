package Categories;

import java.util.ArrayList;
import java.util.List;

public class Electronics extends Product implements IElectronics{
    private String brand;

    public Electronics(String name, double price, int stock, String brand) {
        super(name, price, stock);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
