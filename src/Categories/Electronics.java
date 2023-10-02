package Categories;

public class Electronics extends Product implements IElectronics{
    private String brand;
    private String model;
    private int warrantyInYears;


    public Electronics(String name, double price, int stock, String brand, String model, int warrantyInYears) {
        super(name, price, stock);
        this.brand = brand;
        this.model = model;
        this.warrantyInYears = warrantyInYears;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getWarrantyInYears() {
        return warrantyInYears;
    }
}
