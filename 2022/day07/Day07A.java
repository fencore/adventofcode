import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.Stack;

public class Day07A {
    public static void main(String[] args) {
        Stack<Directory> breadCrumbs = new Stack<Directory>();
        try (Scanner inputFile = new Scanner(Paths.get("input.txt"))) {
            boolean passingBack = false;
            String[] command = new String[3];
            while (inputFile.hasNext() || passingBack) {
                if (!passingBack) {
                    command = inputFile.nextLine().split(" ");
                }
                passingBack = false;
                switch (command[1]) {
                    case "cd": {
                        if (command[2].compareTo("..") == 0) {
                            breadCrumbs.pop();
                        } else if (breadCrumbs.empty()) {
                            breadCrumbs.push(new Directory(command[2], command[2]));
                        } else {
                            breadCrumbs.push(breadCrumbs.peek().moveToSubDir(command[2]));
                        }
                        break;
                    }
                    case "ls": {
                        command = inputFile.nextLine().split(" ");
                        while (!inputFile.hasNext("$") && inputFile.hasNext()) {
                            if (command[0].compareTo("dir") == 0) {
                                breadCrumbs.peek().addDir(command[1]);
                            } else if (command[0].compareTo("$") == 0) {
                                break;
                            } else{
                                breadCrumbs.peek().addFile(Integer.parseInt(command[0]));
                            }
                            command = inputFile.nextLine().split(" ");
                        }
                        passingBack = true;
                    }
                }
            }
        } catch (IOException e) {e.printStackTrace();}
        while (breadCrumbs.size() > 1) {
            breadCrumbs.pop();
        }
        
    }
}
