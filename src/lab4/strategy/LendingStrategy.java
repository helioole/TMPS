package lab4.strategy;

import lab4.templateMethod.Book;
import lab4.templateMethod.FictionBook;
import lab4.templateMethod.NonFictionBook;
import lab4.memento.User;
public class LendingStrategy implements ILendingStrategy {
    public void checkoutBook(User user, Book book) {
        if (book instanceof FictionBook) {
            System.out.println(user.getName() + " checked out a FictionBook: " + book.getTitle());
        } else if (book instanceof NonFictionBook) {
            System.out.println(user.getName() + " checked out a NonFictionBook: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " checked out a book: " + book.getTitle());
        }
    }
    public void returnBook(User user, Book book) {
        if (book instanceof FictionBook) {
            System.out.println(user.getName() + " returned a FictionBook: " + book.getTitle());
        } else if (book instanceof NonFictionBook) {
            System.out.println(user.getName() + " returned a NonFictionBook: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " returned a book: " + book.getTitle());
        }
    }
}

