package lab4;

import lab4.iterator.Iterator;
import lab4.iterator.Library;
import lab4.memento.ReadingProgressMemento;
import lab4.memento.User;
import lab4.strategy.ILendingStrategy;
import lab4.strategy.LendingStrategy;
import lab4.templateMethod.Book;
import lab4.templateMethod.FictionBook;
import lab4.templateMethod.NonFictionBook;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        FictionBook fictionBook = new FictionBook("The Great Gatsby");
        NonFictionBook nonFictionBook = new NonFictionBook("Sapiens");

        library.addBook(fictionBook);
        library.addBook(nonFictionBook);

        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.readBook();
        }

        User user = new User("Alice");
        ILendingStrategy lendingStrategy = new LendingStrategy();
        Book bookToBorrow = fictionBook;

        lendingStrategy.checkoutBook(user, bookToBorrow);

        ReadingProgressMemento progressMemento = user.saveReadingProgress();
        user.restoreReadingProgress(progressMemento);

        lendingStrategy.returnBook(user, bookToBorrow);
    }
}
