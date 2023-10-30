package lab4.templateMethod;

public abstract class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public final void readBook() {
        openBook();
        readContent();
        closeBook();
    }

    abstract void openBook();

    abstract void readContent();

    abstract void closeBook();

    public String getTitle() {
        return title;
    }
}
