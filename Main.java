import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Domains d = new Domains();
        d.initColorsDomain(new ArrayList<String>(Arrays.asList("Yellow", "Blue", "Green", "White", "Red")));
        Utils.printArrayOfArrays(d.getColorsDomain());
    }
}
