import java.util.ArrayList;

public class Solution {
    private ArrayList<String> colors;
    private ArrayList<String> nationalities;
    private ArrayList<String> cigarettes;
    private ArrayList<String> drinks;
    private ArrayList<String> pets;

    public Solution() {
        this.colors = new ArrayList<String>(5);
        this.nationalities = new ArrayList<String>(5);
        this.cigarettes = new ArrayList<String>(5);
        this.drinks = new ArrayList<String>(5);
        this.pets = new ArrayList<String>(5);
    }

    public void setCategory(Category category, ArrayList<String> value) {
        switch (category) {
            case COLORS:
                colors = value;
                break;
            case NATIONALITIES:
                nationalities = value;
                break;
            case CIGARETTES:
                cigarettes = value;
                break;
            case DRINKS:
                drinks = value;
                break;
            default:
                pets = value;
                break;
        }
    }

    public ArrayList<String>  getCategory(Category category) {
        switch (category) {
            case COLORS:
                return colors;
            case NATIONALITIES:
                return nationalities;
            case CIGARETTES:
                return cigarettes;
            case DRINKS:
                return drinks;
            default:
                return pets;
        }
    }

    @Override
    public String toString() {
        return  colors +
                "\n" + nationalities +
                "\n" + cigarettes +
                "\n" + drinks +
                "\n" + pets;
    }
}
