package lab4.strategy;

import lab4.templateMethod.Book;
import lab4.memento.User;

public interface ILendingStrategy {
    void checkoutBook(User user, Book book);

    void returnBook(User user, Book book);
}
