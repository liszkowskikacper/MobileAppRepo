import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class zad3 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("przyklad.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();

        while (reader.hasNextLine()) {
            numbers.add(Integer.parseInt(reader.nextLine()));
        }

        Collections.sort(numbers);

        int threeCount = 0;
        int fiveCount = 0;

        for (int a : numbers) {
            for (int b : numbers) {
                if (b != a && b % a == 0) {
                    for (int c : numbers) {
                        if (c != b && c % b == 0) {
                            threeCount++;
                            for (int d : numbers) {
                                if (d != c && d % c == 0) {
                                    for (int e : numbers) {
                                        if (e != d && e % d == 0) {
                                            fiveCount++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(threeCount + " " + fiveCount);
    }
}
