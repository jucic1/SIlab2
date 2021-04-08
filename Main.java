import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Domains d = new Domains();
        d.initColorsDomain(new ArrayList<String>(Arrays.asList("Yellow", "Blue", "Green", "White", "Red")));
        d.initNationalitiesDomain(new ArrayList<String>(Arrays.asList("English", "German", "Swedish", "Norwegian", "Danish")));
        d.initCigarettesDomain(new ArrayList<String>(Arrays.asList("Filterless", "Pipe", "Cigar", "Menthol", "Light")));
        d.initDrinksDomain(new ArrayList<String>(Arrays.asList("Coffee", "Water", "Tee", "Milk", "Beer")));
        d.initPetsDomain(new ArrayList<String>(Arrays.asList("Horse", "Fish", "Bird", "Dog", "Cat")));
        Utils.printArrayOfArrays(d.getColorsDomain());
    }
}
