package lab2_new.client;

public class Coffee {
    private boolean isReady = false;

    public void prepare() {
        System.out.println("Preparing coffee...");
        isReady = true;
    }

    public void serve() {
        if (isReady) {
            System.out.println("Serving coffee...");
        } else {
            System.out.println("Coffee is not ready yet.");
        }
    }
}
