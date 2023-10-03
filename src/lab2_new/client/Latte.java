package lab2_new.client;

public class Latte extends Coffee {
    @Override
    public void prepare() {
        System.out.println("Steaming milk and brewing coffee...");
        super.prepare();
    }
}
