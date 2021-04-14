import java.util.ArrayList;
import java.util.HashMap;

public class Constraints {
    private ArrayList<HashMap> pairs = new ArrayList();
    private ArrayList<HashMap> leftTo = new ArrayList();
    private ArrayList<HashMap> nextTo = new ArrayList();

    public Constraints() {
    }

    public void addPair(Category firstCategory, String firstValue, Category secondCategory, String secondValue) {
        HashMap<Category, String> newPair = new HashMap();
        newPair.put(firstCategory, firstValue);
        newPair.put(secondCategory, secondValue);
        this.pairs.add(newPair);
    }

    public void addLeftTo(Category myCategory, String myValue, Category leftNeighborsCategory, String leftNeighborsValue) {
        HashMap<Category, String> newPair = new HashMap();
        newPair.put(myCategory, myValue);
        newPair.put(leftNeighborsCategory, leftNeighborsValue);
        this.pairs.add(newPair);
    }

    public void addNextTo(Category myCategory, String myValue, Category neighborsCategory, String neighborsValue) {
        HashMap<Category, String> newNextTo = new HashMap();
        newNextTo.put(myCategory, myValue);
        newNextTo.put(neighborsCategory, neighborsValue);
        this.nextTo.add(newNextTo);
    }

    public ArrayList<HashMap> getPairs() {
        return this.pairs;
    }

    public ArrayList<HashMap> getLeftTo() {
        return this.leftTo;
    }

    public ArrayList<HashMap> getNextTo() {
        return this.nextTo;
    }
}
