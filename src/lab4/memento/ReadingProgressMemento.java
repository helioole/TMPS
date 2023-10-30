package lab4.memento;

public class ReadingProgressMemento {
    private final int savedPage;

    public ReadingProgressMemento(int page) {
        this.savedPage = page;
    }

    public int getSavedPage() {
        return savedPage;
    }
}
