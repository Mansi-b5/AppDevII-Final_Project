package ca.qc.johnabbott.finalproject.viewmodel;

public class CategoryViewModel extends ObservableModel<String> {
    private String categoryToOpen;

    public String getCategoryToOpen() {
        return categoryToOpen;
    }

    public CategoryViewModel setCategoryToOpen(String categoryToOpen) {
        this.categoryToOpen = categoryToOpen;
        return this;
    }

    @Override
    protected String get() {
        return null;
    }
}
