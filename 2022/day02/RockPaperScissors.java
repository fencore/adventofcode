import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

public class RockPaperScissors {
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
                        myScore = myScore + rockScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + drawScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + loseScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + winScore;}
                        break;
                    case 'Y':
                        myScore = myScore + paperScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + winScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + drawScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + loseScore;}
                        break;
                    case 'Z':
                        myScore = myScore + scissorsScore;
                        if (roundMoves.charAt(0) == 'A') {myScore = myScore + loseScore;}
                        else if (roundMoves.charAt(0) == 'B') {myScore = myScore + winScore;}
                        else if (roundMoves.charAt(0) == 'C') {myScore = myScore + drawScore;}
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
