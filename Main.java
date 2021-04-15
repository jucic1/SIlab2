import EisteinRiddle.*;
import MapColoring.MapColoring;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static void solveEisteinRiddle() {
        Domains domains = new Domains();
        domains.initDomain(Category.COLORS, new ArrayList<>(Arrays.asList("Yellow", "Blue", "Green", "Red", "White")));
        domains.initDomain(Category.NATIONALITIES, new ArrayList<>(Arrays.asList("English", "German", "Swedish", "Norwegian", "Danish")));
        domains.initDomain(Category.CIGARETTES, new ArrayList<>(Arrays.asList("Filterless", "Pipe", "Cigar", "Menthol", "Light")));
        domains.initDomain(Category.DRINKS, new ArrayList<>(Arrays.asList("Coffee", "Water", "Tee", "Milk", "Beer")));
        domains.initDomain(Category.PETS, new ArrayList<>(Arrays.asList("Horse", "Fish", "Bird", "Dog", "Cat")));
        domains.filterOutWhereValueNot("Norwegian", 1, Category.NATIONALITIES);
        domains.filterOutWhereValueNot("Milk", 3, Category.DRINKS);
        domains.filterOutWhereValueNotLeftTo("Green", "White", Category.COLORS);

        Constraints constraints = new Constraints();
        constraints.addPair(new Pair(Category.COLORS, "Red"), new Pair(Category.NATIONALITIES, "English"));
        constraints.addPair(new Pair(Category.DRINKS, "Tee"), new Pair(Category.NATIONALITIES, "Danish"));
        constraints.addPair(new Pair(Category.COLORS, "Yellow"), new Pair(Category.CIGARETTES, "Cigar"));
        constraints.addPair(new Pair(Category.CIGARETTES, "Pipe"), new Pair(Category.NATIONALITIES, "German"));
        constraints.addPair(new Pair(Category.CIGARETTES, "Filterless"), new Pair(Category.PETS, "Bird"));
        constraints.addPair(new Pair(Category.NATIONALITIES, "Swedish"), new Pair(Category.PETS, "Dog"));
        constraints.addPair(new Pair(Category.CIGARETTES, "Menthol"), new Pair(Category.DRINKS, "Beer"));
        constraints.addPair(new Pair(Category.COLORS, "Green"), new Pair(Category.DRINKS, "Coffee"));
        constraints.addNextTo(new Pair(Category.NATIONALITIES, "Norwegian"), new Pair(Category.COLORS, "Blue"));
        constraints.addNextTo(new Pair(Category.COLORS, "Yellow"), new Pair(Category.PETS, "Horse"));
        constraints.addNextTo(new Pair(Category.CIGARETTES, "Light"), new Pair(Category.DRINKS, "Water"));
        constraints.addNextTo(new Pair(Category.CIGARETTES, "Light"), new Pair(Category.PETS, "Cat"));

        EinsteinRiddle einsteinRiddle = new EinsteinRiddle(domains, constraints, new ArrayList<>(Arrays.asList(Category.COLORS, Category.NATIONALITIES, Category.CIGARETTES, Category.DRINKS, Category.PETS)));
        einsteinRiddle.runBacktracking();
        einsteinRiddle.printSolution();
    }

    private static void colorMap() {
        MapColoring map = new MapColoring(420, 420, 5, 10);
        if(map.runBacktracking()) {
            map.print();
        }
    }

    public static void main(String[] args) {
        solveEisteinRiddle();
        colorMap();
    }
}
