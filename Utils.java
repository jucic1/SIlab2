import java.util.ArrayList;

public class Utils {
    public static void printArrayOfArrays(ArrayList<ArrayList<String>> arrayOfArrays) {
        for (ArrayList<String> array : arrayOfArrays) {
            for (String item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
