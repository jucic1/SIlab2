import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Domains domains = new Domains();
        domains.initDomain(Category.COLORS, new ArrayList<String>(Arrays.asList("Yellow", "Blue", "Green", "White", "Red")));
        domains.initDomain(Category.NATIONALITIES, new ArrayList<String>(Arrays.asList("English", "German", "Swedish", "Norwegian", "Danish")));
        domains.initDomain(Category.CIGARETTES, new ArrayList<String>(Arrays.asList("Filterless", "Pipe", "Cigar", "Menthol", "Light")));
        domains.initDomain(Category.DRINKS, new ArrayList<String>(Arrays.asList("Coffee", "Water", "Tee", "Milk", "Beer")));
        domains.initDomain(Category.PETS, new ArrayList<String>(Arrays.asList("Horse", "Fish", "Bird", "Dog", "Cat")));
        domains.filterOutWhereValueNot("Norwegian", 2, Category.NATIONALITIES);
        domains.filterOutWhereValueNot("Milk", 3, Category.DRINKS);

        Constraints constraints = new Constraints();
        constraints.addPair(Category.COLORS, "Red", Category.NATIONALITIES, "English");
        constraints.addPair(Category.DRINKS, "Tee", Category.NATIONALITIES, "Danish");
        constraints.addPair(Category.COLORS, "Yellow", Category.CIGARETTES, "Cigar");
        constraints.addPair(Category.CIGARETTES, "Pipe", Category.NATIONALITIES, "German");
        constraints.addPair(Category.CIGARETTES, "Filterless", Category.PETS, "Bird");
        constraints.addPair(Category.NATIONALITIES, "Swedish", Category.PETS, "Dog");
        constraints.addPair(Category.CIGARETTES, "Menthol", Category.DRINKS, "Beer");
        constraints.addPair(Category.COLORS, "Green", Category.DRINKS, "Coffee");
//        constraints.addLeftTo(Category.COLORS, "White", Category.COLORS, "Green");
        constraints.addNextTo(Category.COLORS, "Blue", Category.NATIONALITIES, "Norwegian");
        constraints.addNextTo(Category.COLORS, "Yellow", Category.PETS, "Horse");
        constraints.addNextTo(Category.CIGARETTES, "Light", Category.DRINKS, "Water");
        constraints.addNextTo(Category.CIGARETTES, "Light", Category.PETS, "Cat");

        CSP csp = new CSP(domains, constraints, new ArrayList<Category>(Arrays.asList(Category.COLORS, Category.NATIONALITIES, Category.CIGARETTES, Category.DRINKS, Category.PETS)));
        csp.runBacktracking();
        csp.printSolution();
    }
}
