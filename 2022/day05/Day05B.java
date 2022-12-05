import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Day05B {
    public static void main (String[] args) {
        ArrayList<Stack<Character>> cargoList = new ArrayList<Stack<Character>>();
        try (Scanner inputFile = new Scanner(Paths.get("input.txt"))) {
            String cargoLine = inputFile.nextLine();
            while (!cargoLine.isEmpty()) {
                Stack<Character> tempStack = new Stack<Character>();
                for (int i = 0; i < cargoLine.length(); i++) {
                    tempStack.push(cargoLine.charAt(i));
                }
                cargoList.add(tempStack);
                cargoLine = inputFile.nextLine();
            }

            while (inputFile.hasNext()) {
                int[] moveInstruction = getInstructionList(inputFile.nextLine());
                Stack<Character> tempStack = new Stack<Character>();
                for (int i = 0; i < moveInstruction[0]; i++) {
                        tempStack.push(cargoList.get(moveInstruction[1]-1).pop());
                }

                while (!tempStack.empty()) {
                    cargoList.get(moveInstruction[2]-1).push(tempStack.pop());
                }
            }

            StringBuilder topCrates = new StringBuilder();
            for (int i = 0; i < cargoList.size(); i++) {
                topCrates.append(cargoList.get(i).peek());
            }

            System.out.println(topCrates);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int[] getInstructionList (String s) {
        String[] instruction = s.split(" ");
        int[] numericInstructions = {Integer.valueOf(instruction[1]), Integer.valueOf(instruction[3]), Integer.valueOf(instruction[5])};
        return numericInstructions;
    }
}
