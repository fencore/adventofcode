/*
 * Copyright (C) 2023 fen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package work.zoner.day01;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author fen
 */
public class Day01 {
    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    public static void main(String args[]) {
        int totalVal = 0;
        try (Scanner inputReader = new Scanner(Paths.get("./input"))) {
                while (inputReader.hasNext()) {
                    String tmpString = new String();
                    int[] calVals = new int[2];
                    tmpString = inputReader.nextLine();
                    
                    for(int i = 0; i < tmpString.length(); i++) {
                        if (isNumeric(""+tmpString.charAt(i))) {
                            calVals[0] = Integer.parseInt(tmpString.charAt(i)+"");
                            break;
                        }
                    }
                    
                    for(int i = tmpString.length()-1; i > -1; i--) {
                        if (isNumeric(""+tmpString.charAt(i))) {
                            calVals[1] = Integer.parseInt(tmpString.charAt(i)+"");
                            break;
                        }
                    }
                    
                    //System.out.printf("%d%d%n",calVals[0],calVals[1]); testing outputs
                    totalVal += (calVals[0]*10) + calVals[1];
                }
        } catch (IOException e) {
            System.out.print("File error");
        }
        System.out.println(totalVal);
    }
}