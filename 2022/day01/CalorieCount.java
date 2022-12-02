import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class CalorieCount {
    public static void main (String[] args) {
        try (Scanner inputReader = new Scanner(Paths.get("input.txt"))) {
            int maxCals = 0;
            while (inputReader.hasNext()) {
                int currentCals = 0;
                String inLine = new String();
                do {
                    inLine = inputReader.nextLine();
                    if (!inLine.isEmpty()) {
                        currentCals += Integer.parseInt(inLine);
                        System.out.printf("Current elf total is %d%n", currentCals);
                    }
                } while (!inLine.isEmpty() && inputReader.hasNext());

                if (currentCals > maxCals) {
                    maxCals = currentCals;
                    System.out.printf("New Max Cals: %d%n", maxCals);
                }
            }
            System.out.printf("The large calories carried is: %d%n", maxCals);
        } catch (IOException e) {
            System.out.println("IOException");
			e.printStackTrace();
        }        
    }
}