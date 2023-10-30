package lab4.iterator;

import lab4.templateMethod.Book;

import java.util.List;

public class BookIterator implements Iterator<Book> {
    private List<Book> books;
    private int position = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    public boolean hasNext() {
        return position < books.size();
    }

    public Book next() {
        return hasNext() ? books.get(position++) : null;
    }
}
