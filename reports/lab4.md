# Laboratory Work Nr.4

### Course: Software Design Techniques and Mechanisms
### Topic: Behavioral Design Patterns
### Author: Racovcena Irina
### Group: FAF-212

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Design patterns that were implemented in this laboratory work:

* Iterator
* Memento
* Strategy
* Template Method

## Implementation

### Iterator

Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

In this project `Library` class provides the `createIterator()` method, which returns an instance of the `BookIterator` class, allowing us to iterate over the books in the library.
The `BookIterator` class implements the `Iterator` interface, providing methods like `hasNext()` and `next()` to iterate through the books stored in the library.
This separation of concerns allows us to iterate over the collection of books without exposing the internal details of the Library class.

Example in the code:

```java
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

```

```java
public class Library implements LibraryCollection {
    private List<Book> books = new ArrayList<>();
    
    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
}

```

### Strategy 
Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

Here, `LendingStrategy` class is used to define different lending strategies within its methods, allowing us to choose and apply a specific strategy when checking out and returning books.

Example in the code:

```java
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

```

### Memento

Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.

In this project `ReadingProgress` class is responsible for capturing and managing the reading progress of a user and 
`ReadingProgressMemento` class represents the state of the `ReadingProgress` class at a specific point in time.

Example in the code:
```java
public class ReadingProgress {
    private int currentPage;

    public ReadingProgressMemento save() {
        return new ReadingProgressMemento(currentPage);
    }

    public void restore(ReadingProgressMemento memento) {
        this.currentPage = memento.getSavedPage();
    }
}
```

```java
public class ReadingProgressMemento {
    private final int savedPage;

    public ReadingProgressMemento(int page) {
        this.savedPage = page;
    }

    public int getSavedPage() {
        return savedPage;
    }
}

```

### Template Method

Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

The `Book` class defines a template method, `readBook()`, that outlines the high-level algorithm for reading a book, including opening, reading content, and closing the book.
Subclasses of `Book`, such as `FictionBook` and `NonFictionBook`, provide concrete implementations for the methods openBook(), readContent(), and closeBook(), customizing the behavior for different types of books.

Example in the code:

```java
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

```

## Conclusion
In conclusion, this laboratory work on behavioral design patterns is a practical approach to understanding 
and applying these patterns in real-world scenarios.
Behavioral design patterns in software engineering deal with how objects interact and communicate with one another. 
They focus on the responsibilities and relationships between objects.
These patterns are essential for structuring and organizing code.