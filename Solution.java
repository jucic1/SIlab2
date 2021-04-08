import java.util.ArrayList;

public class Solution {
    private ArrayList<String> colors;
    private ArrayList<String> nationalities;
    private ArrayList<String> cigarettes;
    private ArrayList<String> drinks;
    private ArrayList<String> pets;

    public Solution() {
        colors = new ArrayList<String>(5);
        nationalities = new ArrayList<String>(5);
        cigarettes = new ArrayList<String>(5);
        drinks = new ArrayList<String>(5);
        pets = new ArrayList<String>(5);
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public ArrayList<String> getNationalities() {
        return nationalities;
    }

    public ArrayList<String> getCigarettes() {
        return cigarettes;
    }

    public ArrayList<String> getSmokes() {
        return cigarettes;
    }

    public ArrayList<String> getPets() {
        return pets;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public void setNationalities(ArrayList<String> nationalities) {
        this.nationalities = nationalities;
    }

    public void setCigarettes(ArrayList<String> cigarettes) {
        this.cigarettes = cigarettes;
    }

    public void setDrinks(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public void setPets(ArrayList<String> pets) {
        this.pets = pets;
    }
}
