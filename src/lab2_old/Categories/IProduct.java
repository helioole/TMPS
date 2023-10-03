package lab2_old.Categories;

public interface IProduct {
    String getName();

    double getPrice();

    int getStock();

    void decreaseStock(int quantity);
}
