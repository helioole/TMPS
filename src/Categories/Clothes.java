package Categories;

import java.util.ArrayList;
import java.util.List;

public class Clothes extends Product implements IClothes{
    private String size;
    private static List<Clothes> items = new ArrayList<>();

    public Clothes(String name, double price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
        items.add(this);
    }

    public String getSize() {
        return size;
    }
}
