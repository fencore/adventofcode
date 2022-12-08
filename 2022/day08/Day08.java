import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Day08 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> forest = new ArrayList<ArrayList<Integer>>();
        try {
            List<String> inputFile = Files.readAllLines(Paths.get("input.txt"));
            for (String s : inputFile) {
                ArrayList<Integer> i = new ArrayList<Integer>();
                for (int j = 0; j < s.length(); j++) {
                    i.add(Integer.parseInt("" + s.charAt(j)));
                }
                forest.add(i);
            }
        } catch (IOException e) {e.printStackTrace();}
        
        int visCount = 0, maxSight = 0;

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (visChecks(forest, i, j)) {visCount++;}
                int curSight = treeChecks(forest, i, j);
                if (curSight > maxSight) {maxSight = curSight;}
            }
        }
        System.out.println("Part 1: " + visCount);
        System.out.println("Part 2: " + maxSight);
    }

    public static boolean visChecks(ArrayList<ArrayList<Integer>> arr, int i, int j) {
        boolean flagN = true, flagS = true, flagW = true, flagE = true;
        if (i == 0 || j == 0 || i == arr.size()-1 || j == arr.get(i).size()-1) {return true;} //check border
        for (int y = i-1; y >= 0; y--) {//check north
            if (arr.get(y).get(j) >= arr.get(i).get(j)) {flagN = false; break;}
        }
        for (int y = i+1; y < arr.size(); y++) { //check south
            if (arr.get(y).get(j) >= arr.get(i).get(j)) {flagS = false; break;}
        }
        for (int z = j-1; z >= 0; z--) { //check west
            if (arr.get(i).get(z) >= arr.get(i).get(j)) {flagW = false; break;}
        }
        for (int z = j+1; z < arr.get(i).size(); z++) { //check east
            if (arr.get(i).get(z) >= arr.get(i).get(j)) {flagE = false; break;}
        }
        if (flagN || flagS || flagW || flagE) {return true;}
        return false;
    }

    public static Integer treeChecks(ArrayList<ArrayList<Integer>> arr, int i, int j) {
        int incN = i, incS = arr.size()-1 - i, incW = j, incE = arr.get(i).size()-1 - j;
        for (int y = i-1; y >= 0; y--) {//check north
            if (arr.get(y).get(j) >= arr.get(i).get(j)) {incN = i - y; break;}
        }
        for (int y = i+1; y < arr.size(); y++) { //check south
            if (arr.get(y).get(j) >= arr.get(i).get(j)) {incS = y - i; break;}
        }
        for (int z = j-1; z >= 0; z--) { //check west
            if (arr.get(i).get(z) >= arr.get(i).get(j)) {incW = j - z; break;}
        }
        for (int z = j+1; z < arr.get(i).size(); z++) { //check east
            if (arr.get(i).get(z) >= arr.get(i).get(j)) {incE = z - j; break;}
        }
        return incN * incS * incW * incE;
    }
}