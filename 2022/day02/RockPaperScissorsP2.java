import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

public class RockPaperScissorsP2 {
    public static void main (String[] args) {
        //Variables!
        String roundMoves = new String();
        int myScore = 0;
        int winScore = 6;
        int drawScore = 3;
        int loseScore = 0;
        int rockScore = 1;
        int paperScore = 2;
        int scissorsScore = 3;

        //Open the dang file
        try(Scanner inputStream = new Scanner(Paths.get("input.txt"));) {
            while (inputStream.hasNext()) {
                roundMoves = inputStream.nextLine();
                switch (roundMoves.charAt(2)) {
                    case 'X':
                        myScore = myScore + loseScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + scissorsScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + rockScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + paperScore;}
                        break;
                    case 'Y':
                        myScore = myScore + drawScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + rockScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + paperScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + scissorsScore;}
                        break;
                    case 'Z':
                        myScore = myScore + winScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + paperScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + scissorsScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + rockScore;}
                        break;
                }
            }
            System.out.printf("Your score is %d%n", myScore);
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }

    }    
}
