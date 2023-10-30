package lab4.memento;

import lab4.memento.ReadingProgress;
import lab4.memento.ReadingProgressMemento;

public class User {
    private String name;
    private ReadingProgress readingProgress;

    public User(String name) {
        this.name = name;
        this.readingProgress = new ReadingProgress();
    }

    public String getName() {
        return name;
    }

    public ReadingProgressMemento saveReadingProgress() {
        System.out.println("Saving reading progress for " + name);
        return readingProgress.save();
    }

    public void restoreReadingProgress(ReadingProgressMemento memento) {
        readingProgress.restore(memento);
        System.out.println("Restoring reading progress for " + name);
    }
}
