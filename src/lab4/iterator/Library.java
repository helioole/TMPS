package lab4.iterator;

import lab4.templateMethod.Book;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryCollection {
    private List<Book> books = new ArrayList<>();

    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
