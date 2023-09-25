package Categories;

import java.util.ArrayList;
import java.util.List;

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
