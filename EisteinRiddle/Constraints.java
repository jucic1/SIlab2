package EisteinRiddle;

import java.util.ArrayList;

public class Constraints {
    private ArrayList<ArrayList<Pair>> pairs = new ArrayList<>();
    private ArrayList<ArrayList<Pair>> leftTo = new ArrayList<>();
    private ArrayList<ArrayList<Pair>> nextTo = new ArrayList<>();

    public Constraints() {
    }

    public void addPair(Pair firstPair, Pair secondPair) {
        ArrayList<Pair> newPair = new ArrayList<>();
        newPair.add(firstPair);
        newPair.add(secondPair);
        this.pairs.add(newPair);
    }

    public void addLeftTo(Pair myPair, Pair leftNeighborPair) {
        ArrayList<Pair> newPair = new ArrayList<>();
        newPair.add(myPair);
        newPair.add(leftNeighborPair);
        this.leftTo.add(newPair);
    }

    public void addNextTo(Pair myPair, Pair neighborPair) {
        ArrayList<Pair> newPair = new ArrayList<>();
        newPair.add(myPair);
        newPair.add(neighborPair);
        this.nextTo.add(newPair);
        ArrayList<Pair> revertedPair = new ArrayList<>();
        revertedPair.add(neighborPair);
        revertedPair.add(myPair);
        this.nextTo.add(revertedPair);
    }

    public ArrayList<ArrayList<Pair>> getPairs() {
        return pairs;
    }

    public ArrayList<ArrayList<Pair>> getLeftTo() {
        return leftTo;
    }

    public ArrayList<ArrayList<Pair>> getNextTo() {
        return nextTo;
    }
}
