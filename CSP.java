import java.util.ArrayList;
import java.util.HashMap;

public class CSP {
    private Solution solution;
    private Domains domains;
    private Constraints constraints;
    private ArrayList<Category> categoriesOrder;

    public CSP(Domains domains, Constraints constraints, ArrayList<Category> categoriesOrder) {
        solution = new Solution();
        this.domains = domains;
        this.constraints = constraints;
        this.categoriesOrder = categoriesOrder;
    }

    public void runBacktracking() {
        this.canAssignValueToCategory(0, solution);
    }

    public void printSolution() {
        System.out.println(solution);
    }

    private boolean canAssignValueToCategory(int categoryNr, Solution solution) {
        if (categoryNr == 5) {
            return true;
        }

        for (ArrayList<String> value : domains.getCategory(categoriesOrder.get(categoryNr))) {
            Category category = categoriesOrder.get(categoryNr);
            if (canPlaceValue(solution, category, value, constraints)) {
                solution.setCategory(category, value);
                if (canAssignValueToCategory(categoryNr + 1, solution)) {
                    return true;
                }
                solution.setCategory(category, new ArrayList<String>(5));
            }
        }
        return false;
    }

    private boolean canPlaceValue(Solution solution, Category category, ArrayList<String> value, Constraints constraints) {
        //if IS constraint validated
        for (HashMap pairs : constraints.getPairs()) {
            Category firstCategory = (Category) pairs.keySet().toArray()[0];
            Category secondCategory = (Category) pairs.keySet().toArray()[1];
            if (pairs.keySet().contains(category)) {
                Category otherCategory = category.equals(firstCategory) ? secondCategory : firstCategory;
                int houseIndex = value.indexOf(pairs.get(category));

                if (!solution.getCategory(otherCategory).isEmpty() && !solution.getCategory(otherCategory).get(houseIndex).equals(pairs.get(otherCategory))) {
                    return false;
                }
            }
        }

        //if NEXT TO constraint validated
        for (HashMap nextTo : constraints.getNextTo()) {
            Category firstCategory = (Category) nextTo.keySet().toArray()[0];
            Category secondCategory = (Category) nextTo.keySet().toArray()[1];
            if (nextTo.keySet().contains(category)) {
                Category otherCategory = category.equals(firstCategory) ? secondCategory : firstCategory;
                int houseIndex = value.indexOf(nextTo.get(category));

                if (!solution.getCategory(otherCategory).isEmpty()) {
                    if (solution.getCategory(otherCategory).get(houseIndex).equals(nextTo.get(otherCategory))) { //cant have something my neighbor is supposed to have
                        return false;
                    } else if (houseIndex == 0) {
                        if (!solution.getCategory(otherCategory).get(houseIndex + 1).equals(nextTo.get(otherCategory))) {
                            return false;
                        }
                    } else if (houseIndex == 4) {
                        if (!solution.getCategory(otherCategory).get(houseIndex - 1).equals(nextTo.get(otherCategory))) {
                            return false;
                        }
                    } else {
                        if (!solution.getCategory(otherCategory).get(houseIndex - 1).equals(nextTo.get(otherCategory)) && !solution.getCategory(otherCategory).get(houseIndex + 1).equals(nextTo.get(otherCategory))) {
                            return false;
                        }
                    }
                }
            }
        }


        return true;
    }
}
