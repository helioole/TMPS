package lab2_new.client;

public class Cappuccino extends Coffee {
    @Override
    public void prepare() {
        System.out.println("Frothing milk and brewing coffee...");
        super.prepare();
    }
}
