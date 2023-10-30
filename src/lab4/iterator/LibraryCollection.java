package lab4.iterator;

import lab4.iterator.Iterator;
import lab4.templateMethod.Book;

public interface LibraryCollection {
    Iterator<Book> createIterator();

    void addBook(Book book);
}
