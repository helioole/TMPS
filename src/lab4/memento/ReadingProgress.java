package lab4.memento;
public class ReadingProgress {
    private int currentPage;

    public ReadingProgressMemento save() {
        return new ReadingProgressMemento(currentPage);
    }

    public void restore(ReadingProgressMemento memento) {
        this.currentPage = memento.getSavedPage();
    }
}
