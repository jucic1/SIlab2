package EisteinRiddle;

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

    public void initDomain(Category category, ArrayList<String> possibleValues){
        switch (category) {
            case COLORS:
                colorsDomain = allCombinations(possibleValues);
                break;
            case NATIONALITIES:
                nationalitiesDomain = allCombinations(possibleValues);
                break;
            case CIGARETTES:
                cigarettesDomain = allCombinations(possibleValues);
                break;
            case DRINKS:
                drinksDomain = allCombinations(possibleValues);
                break;
            default:
                petsDomain = allCombinations(possibleValues);
                break;
        }
    }

    private ArrayList<ArrayList<String>> allCombinations(ArrayList<String> possibleValues) {
        ArrayList<ArrayList<String>> allCombinations = new ArrayList<>();

        Collection<List<String>> permutations = Collections2.permutations(possibleValues);
        for (List<String> permutation : permutations) {
            allCombinations.add(new ArrayList<>(permutation));
        }
        return allCombinations;
    }

    public ArrayList<ArrayList<String>> getCategory(Category category) {
        switch (category) {
            case COLORS:
                return colorsDomain;
            case NATIONALITIES:
                return nationalitiesDomain;
            case CIGARETTES:
                return cigarettesDomain;
            case DRINKS:
                return drinksDomain;
            default:
                return petsDomain;
        }
    }

    public void filterOutWhereValueNot(String value, int order, Category category) {
        switch (category) {
            case COLORS:
                colorsDomain = filterOutWhereValueNot(colorsDomain, value, order-1);
                break;
            case NATIONALITIES:
                nationalitiesDomain = filterOutWhereValueNot(nationalitiesDomain, value, order-1);
                break;
            case CIGARETTES:
                cigarettesDomain = filterOutWhereValueNot(cigarettesDomain, value, order-1);
                break;
            case DRINKS:
                drinksDomain = filterOutWhereValueNot(drinksDomain, value, order-1);
                break;
            default:
                petsDomain = filterOutWhereValueNot(petsDomain, value, order-1);
                break;
        }
    }

    private ArrayList<ArrayList<String>> filterOutWhereValueNot(ArrayList<ArrayList<String>> domain, String value, int order){
        ArrayList<ArrayList<String>> arrayAfterFilteringOut = new ArrayList<>();

        for (ArrayList<String> combination : domain) {
            if(combination.get(order).equals(value)) {
                arrayAfterFilteringOut.add(combination);
            }
        }
       return arrayAfterFilteringOut;
    }

    public void filterOutWhereValueNotLeftTo(String leftValue, String myValue, Category category) {
        switch (category) {
            case COLORS:
                colorsDomain = filterOutWhereValueNotLeftTo(colorsDomain, leftValue, myValue);
                break;
            case NATIONALITIES:
                nationalitiesDomain = filterOutWhereValueNotLeftTo(nationalitiesDomain, leftValue, myValue);
                break;
            case CIGARETTES:
                cigarettesDomain = filterOutWhereValueNotLeftTo(cigarettesDomain, leftValue, myValue);
                break;
            case DRINKS:
                drinksDomain = filterOutWhereValueNotLeftTo(drinksDomain, leftValue, myValue);
                break;
            default:
                petsDomain = filterOutWhereValueNotLeftTo(petsDomain, leftValue, myValue);
                break;
        }
    }

    private ArrayList<ArrayList<String>> filterOutWhereValueNotLeftTo(ArrayList<ArrayList<String>> domain, String leftValue, String myValue) {
        ArrayList<ArrayList<String>> arrayAfterFilteringOut = new ArrayList<>();

        for (ArrayList<String> combination : domain) {
            int myIndex = combination.indexOf(myValue);
            if(myIndex!= 0 && combination.get(myIndex).equals(myValue) && combination.get(myIndex-1).equals(leftValue)) {
                arrayAfterFilteringOut.add(combination);
            }
        }
        return arrayAfterFilteringOut;
    }
}