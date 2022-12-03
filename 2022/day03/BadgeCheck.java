import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;

public class BadgeCheck {
    public static void main (String[] args) {
        String bag1, bag2, bag3 = new String();
        int prioritySum = 0;

        try (Scanner inputLine = new Scanner(Paths.get("input.txt"))) {
            while (inputLine.hasNext()) {
                bag1 = inputLine.nextLine();
                bag2 = inputLine.nextLine();
                bag3 = inputLine.nextLine();
                boolean breakFlag = false;
                for (int i = 0; i < bag1.length() && breakFlag == false; i++) {
                    for (int j = 0; j < bag2.length() && breakFlag == false; j++) {
                        if (bag1.charAt(i) == bag2.charAt(j)) {
                            for (int k = 0; k < bag3.length() && breakFlag == false; k++) {
                                if (bag2.charAt(j) == bag3.charAt(k)) {
                                    prioritySum += PriorityScore.score(bag3.charAt(k));
                                    breakFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Total score for matching chars is: %d", prioritySum);
    }
}
