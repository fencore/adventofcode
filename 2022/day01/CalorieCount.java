import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class CalorieCount {
    public static void main(String[] args) {
        try (Scanner inputReader = new Scanner(Paths.get("input.txt"))) {
            int maxCals = 0;
            while (inputReader.hasNext()) {
                int currentCals = 0;
                String inLine = new String();
                do {
                    inLine = inputReader.nextLine();
                    if (!inLine.isEmpty()) {
                        currentCals += Integer.parseInt(inLine);
                    }
                } while (!inLine.isEmpty());

                if (currentCals > maxCals) {maxCals = currentCals;}
            }
            System.out.printf("The large calories carried is: %d", maxCals);
        } catch (IOException e) {
            System.out.println("IOException");
			e.printStackTrace();
        }        
    }
}