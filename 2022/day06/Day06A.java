import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;

public class Day06A {
    public static void main (String[] args) {
        try (Scanner inputFile = new Scanner(Paths.get("input.txt"))) {
            char[] signal = inputFile.nextLine().toCharArray();
            for (int i = 0; i + 3 < signal.length; i++) {
                if (distinctValues(Arrays.copyOfRange(signal, i, i + 4))) {
                    System.out.printf("Characters processed: %d%n", i + 4);
                    System.exit(0);
                }
            }
        } catch (IOException e ) {}
    }

    public static boolean distinctValues(char[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                 if (arr[i] == arr[j]) {
                     return false;
                 }
            }
        }              
        return true;          
    }
}
