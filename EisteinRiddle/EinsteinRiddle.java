package EisteinRiddle;

import java.util.ArrayList;

public class EinsteinRiddle {
    private Solution solution;
    private Domains domains;
    private Constraints constraints;
    private ArrayList<Category> categoriesOrder;

    public EinsteinRiddle(Domains domains, Constraints constraints, ArrayList<Category> categoriesOrder) {
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
                solution.setCategory(category, new ArrayList<>(5));
            }
        }
        return false;
    }

    private boolean canPlaceValue(Solution solution, Category category, ArrayList<String> value, Constraints constraints) {
        //if IS constraint validated
        for (ArrayList<Pair> pairs : constraints.getPairs()) {
            Pair firstPair = pairs.get(0);
            Pair secondPair = pairs.get(1);
            if (firstPair.getCategory().equals(category) || secondPair.getCategory().equals(category)) {
                Pair otherPair = firstPair.getCategory().equals(category) ? secondPair : firstPair;
                int houseIndex = firstPair.getCategory().equals(category) ? value.indexOf(firstPair.getValue()) : value.indexOf(secondPair.getValue());

                if (!solution.getCategory(otherPair.getCategory()).isEmpty() && !solution.getCategory(otherPair.getCategory()).get(houseIndex).equals(otherPair.getValue())) {
                    return false;
                }
            }
        }

        //if NEXT TO constraint validated
        for (ArrayList<Pair> nextTo : constraints.getNextTo()) {
            Pair myPair = nextTo.get(0);
            Pair nextToPair = nextTo.get(1);
            if (myPair.getCategory().equals(category)) {
                int houseIndex = value.indexOf(myPair.getValue());

                if (!solution.getCategory(nextToPair.getCategory()).isEmpty()) {
                    if (solution.getCategory(nextToPair.getCategory()).get(houseIndex).equals(nextToPair.getValue())) { //cant have something my neighbor is supposed to have
                        return false;
                    } else if (houseIndex == 0) {
                        if (!solution.getCategory(nextToPair.getCategory()).get(houseIndex + 1).equals(nextToPair.getValue())) {
                            return false;
                        }
                    } else if (houseIndex == 4) {
                        if (!solution.getCategory(nextToPair.getCategory()).get(houseIndex - 1).equals(nextToPair.getValue())) {
                            return false;
                        }
                    } else {
                        if (!solution.getCategory(nextToPair.getCategory()).get(houseIndex - 1).equals(nextToPair.getValue()) && !solution.getCategory(nextToPair.getCategory()).get(houseIndex + 1).equals(nextToPair.getValue())) {
                            return false;
                        }
                    }
                }
            }
        }

        //if LEFT TO constraint validated
        for (ArrayList<Pair> leftTo : constraints.getLeftTo()) {
            Pair myPair = leftTo.get(0);
            Pair leftToPair = leftTo.get(1);
            if (myPair.getCategory().equals(category)) {
                int houseIndex = value.indexOf(myPair.getValue());

                if (!solution.getCategory(leftToPair.getCategory()).isEmpty()) {
                    if (houseIndex == 0) { //i cant have a left neighbor if im first in the row
                        return false;
                    } else if (solution.getCategory(leftToPair.getCategory()).get(houseIndex).equals(leftToPair.getValue())) { //cant have something my neighbor is supposed to have
                        return false;
                    } else {
                        if(!solution.getCategory(leftToPair.getCategory()).get(houseIndex - 1).equals(leftToPair.getValue())) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
