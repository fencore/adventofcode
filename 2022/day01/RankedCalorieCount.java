import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class RankedCalorieCount {
    public static void main (String[] args) {
        try (Scanner inputReader = new Scanner(Paths.get("input.txt"))) {
            ArrayList<Integer> calsList = new ArrayList<Integer>();
            while (inputReader.hasNext()) {
                int currentCals = 0;
                String inLine = new String();
                do {
                    inLine = inputReader.nextLine();
                    if (!inLine.isEmpty()) {
                        currentCals += Integer.parseInt(inLine);
                    }
                } while (!inLine.isEmpty() && inputReader.hasNext());
                calsList.add(currentCals);
            }

            Collections.sort(calsList);
            Collections.reverse(calsList);
            int topThreeSum = calsList.get(0)+calsList.get(1)+calsList.get(2);
            System.out.printf("The sum of calories by the top three is: %d%n", topThreeSum);
        } catch (IOException e) {
            System.out.println("IOException");
			e.printStackTrace();
        }        
    }
}