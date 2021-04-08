import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Domains {
    private ArrayList<ArrayList<String>> colorsDomain;
    private ArrayList<ArrayList<String>> nationalitiesDomain;
    private ArrayList<ArrayList<String>> cigarettesDomain;
    private ArrayList<ArrayList<String>> drinksDomain;
    private ArrayList<ArrayList<String>> petsDomain;

    public void initColorsDomain(ArrayList<String> possibleValues) {
        colorsDomain = allCombinations(possibleValues);
    }
    public void initNationalitiesDomain(ArrayList<String> possibleValues) {
        nationalitiesDomain = allCombinations(possibleValues);
    }
    public void initCigarettesDomain(ArrayList<String> possibleValues) {
        cigarettesDomain = allCombinations(possibleValues);
    }
    public void initDrinksDomain(ArrayList<String> possibleValues) {
        drinksDomain = allCombinations(possibleValues);
    }
    public void initPetsDomain(ArrayList<String> possibleValues) {
        petsDomain = allCombinations(possibleValues);
    }

    private ArrayList<ArrayList<String>> allCombinations(ArrayList<String> possibleValues) {
        ArrayList<ArrayList<String>> allCombinations = new ArrayList<ArrayList<String>>();

        Collection<List<String>> permutations = Collections2.permutations(possibleValues);
        for (List<String> permutation : permutations) {
            allCombinations.add(new ArrayList<String>(permutation));
        }
        return allCombinations;
    }

    public ArrayList<ArrayList<String>> getColorsDomain() {
        return colorsDomain;
    }
}