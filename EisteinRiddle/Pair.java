package EisteinRiddle;

public class Pair {
    private Category category;
    private String value;

    public Pair(Category category, String value) {
        this.category = category;
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
