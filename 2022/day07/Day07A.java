import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Day07A {
    public static void main(String[] args) {
        Stack<Directory> crumbs = new Stack<Directory>();
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
                            crumbs.pop();
                        } else if (crumbs.empty()) {
                            crumbs.push(new Directory(command[2], command[2]));
                        } else {
                            crumbs.push(crumbs.peek().moveToSubDir(command[2]));
                        }
                        break;
                    }
                    case "ls": {
                        command = inputFile.nextLine().split(" ");
                        while (!inputFile.hasNext("$") && inputFile.hasNext()) {
                            if (command[0].compareTo("dir") == 0) {
                                crumbs.peek().addDir(command[1]);
                            } else if (command[0].compareTo("$") == 0) {
                                break;
                            } else{
                                crumbs.peek().addFile(Integer.parseInt(command[0]));
                            }
                            command = inputFile.nextLine().split(" ");
                        }
                        passingBack = true;
                    }
                }
            }
        } catch (IOException e) {e.printStackTrace();}
        while (crumbs.size() > 1) {
            crumbs.pop();
        }
        ArrayList<Integer> sizes = crumbs.peek().sizeHierarchy();
        int sum = 0;
        for (Integer i : sizes) {
            if (i <= 100000) {
                sum += i;
            }
        }
        System.out.println(sum);

        Stack<Integer> sortList = new Stack<Integer>();
        for (Integer i : sizes) {
            if (i >= (30000000 - (70000000 - Collections.max(sizes)))) {
                sortList.push(i);
            }
        }
        System.out.println(Collections.min(sortList));     
    }
}
