package Categories;

public class Clothes extends Product implements IClothes{
    private String size;
    private String fabric;
    public Clothes(String name, double price, int stock, String size, String fabric) {
        super(name, price, stock);
        this.size = size;
        this.fabric = fabric;
    }


    public String getSize() {
        return size;
    }

    public String getFabric() {
        return fabric;
    }
}
