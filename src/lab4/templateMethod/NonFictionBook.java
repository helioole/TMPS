package lab4.templateMethod;

import lab4.templateMethod.Book;

public class NonFictionBook extends Book {
    public NonFictionBook(String title) {
        super(title);
    }

    @Override
    void openBook() {
        System.out.println("Opening " + getTitle());
    }

    @Override
    void readContent() {
        System.out.println("Reading the informative content of " + getTitle());
    }

    @Override
    void closeBook() {
        System.out.println("Closing " + getTitle());
    }
}
