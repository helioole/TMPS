package lab2_old.Builders;

import lab2_old.Categories.Clothes;


public class ClothesBuilder extends ProductBuilder<ClothesBuilder> {
    private String size;
    private String fabric;

    public ClothesBuilder withSize(String size) {
        this.size = size;
        return self();
    }

    public ClothesBuilder withFabric(String fabric) {
        this.fabric = fabric;
        return self();
    }

    @Override
    public Clothes build() {
        return new Clothes(name, price, stock, size, fabric);
    }
}