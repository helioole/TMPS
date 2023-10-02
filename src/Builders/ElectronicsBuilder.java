package Builders;
import Categories.*;

public class ElectronicsBuilder extends ProductBuilder<ElectronicsBuilder> {
    private String brand;
    private String model;
    private int warrantyInYears;

    public ElectronicsBuilder withBrand(String brand) {
        this.brand = brand;
        return self();
    }

    public ElectronicsBuilder withModel(String model) {
        this.model = model;
        return self();
    }

    public ElectronicsBuilder withWarrantyInYears(int warrantyInYears) {
        this.warrantyInYears = warrantyInYears;
        return self();
    }

    @Override
    public Electronics build() {
        return new Electronics(name, price, stock, brand, model, warrantyInYears);
    }
}

