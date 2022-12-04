import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;

public class Day04B {
    public static void main (String[] args) {
        int rangeEnclosuresCount = 0;

        try (Scanner inputFile = new Scanner(Paths.get("input.txt"))) {
            while (inputFile.hasNext()) {
                int[] rangeList = rangeLineIntegerification(inputFile.nextLine());
                if (Math.max(rangeList[0], rangeList[2]) <= Math.min(rangeList[1], rangeList[3])) {rangeEnclosuresCount++;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("The number of overlapping ranges is: %d", rangeEnclosuresCount);
    }

    public static int[] rangeLineIntegerification(String textRanges) {
        int[] intRanges = new int[4];
        String[] ranges = textRanges.split("[,-]");
        for (int i = 0; i < 4; i++) {
            intRanges[i] = Integer.parseInt(ranges[i]);
        }
        return intRanges;
    }
}
