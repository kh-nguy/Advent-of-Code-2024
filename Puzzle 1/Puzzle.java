import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Puzzle {
    public static void main() {
        String inputFile = "C:\\Users\\Kenny\\Documents\\Advent of Code 2024\\Puzzle 1\\input.txt";
        try {
            File file = new File(inputFile);
            Scanner in = new Scanner(file);

            int leftVar, rightVar = 0;

            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();

            int leftSmallest, rightSmallest;
            int sum = 0, diff = 0;

            while (in.hasNext()) {
                leftVar = in.nextInt();
                left.add(leftVar);
                rightVar = in.nextInt();
                right.add(rightVar);
            } // end while

            // sorting the lists
            Collections.sort(left);
            Collections.sort(right);

            // Part 1
            for (int i = 0; i < left.size(); i++) {
                diff = Math.abs(left.get(i) - right.get(i));
                sum += diff;
            } // end for
            System.out.println(sum);
            sum = 0;

            // Part 2
            int count = 0;
            int similarity = 0;
            for (int i = 0; i < left.size(); i++) {
                int x = left.get(i);
                for (int j = 0; j < right.size(); j++) {
                    int y = right.get(j);
                    if (x == y) {
                        count++;
                        similarity = x * count;
                        count = 0;
                        sum += similarity;
                    }
                } // end for
            } // end for
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } // end try-catch
    } // end main
} // end Puzzle