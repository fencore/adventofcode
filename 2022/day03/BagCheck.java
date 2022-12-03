import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;

public class BagCheck {
    public static void main (String[] args) {
        String bagContents = new String();
        int prioritySum = 0;
        
        try (Scanner inputLine = new Scanner(Paths.get("input.txt"))) {
            while (inputLine.hasNext()) {
                bagContents = inputLine.nextLine();
                boolean breakFlag = false;
                for (int i = 0; i <= (bagContents.length()/2) && breakFlag == false; i++) { //iterates first half of string
                    for (int j = (bagContents.length()/2); j <= bagContents.length()-1 && breakFlag == false; j++) { //iterates second half of string
                        if (bagContents.charAt(i) == bagContents.charAt(j)) {
                            prioritySum += PriorityScore.score(bagContents.charAt(i));
                            //System.out.printf("Bag Contents: %s :: Matching char %s%n", bagContents, bagContents.charAt(i)); //print for testing purposes
                            breakFlag = true;
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
