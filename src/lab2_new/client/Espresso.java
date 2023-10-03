package lab2_new.client;

public class Espresso extends Coffee {
    @Override
    public void prepare() {
        System.out.println("Brewing espresso...");
        super.prepare();
    }
}
