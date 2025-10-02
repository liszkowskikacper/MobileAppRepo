import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class zad2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("liczby.txt"));

        int mostFactors = 0;
        int numberWithMostFactors = 0;
        int mostDifferentFactors = 0;
        int numberWithMostDifferentFactors = 0;

        while (fileReader.hasNextLine()) {
            int number = Integer.parseInt(fileReader.nextLine());
            int current = number;
            int factor = 2;

            ArrayList<Integer> allFactors = new ArrayList<>();
            ArrayList<Integer> differentFactors = new ArrayList<>();

            while (current > 1) {
                while (current % factor == 0) {
                    allFactors.add(factor);
                    if (!differentFactors.contains(factor)) {
                        differentFactors.add(factor);
                    }
                    current /= factor;
                }
                factor++;
            }

            if (allFactors.size() > mostFactors) {
                mostFactors = allFactors.size();
                numberWithMostFactors = number;
            }

            if (differentFactors.size() > mostDifferentFactors) {
                mostDifferentFactors = differentFactors.size();
                numberWithMostDifferentFactors = number;
            }
        }

        System.out.println(numberWithMostFactors + " " + mostFactors + " " + numberWithMostDifferentFactors + " " + mostDifferentFactors);
    }
}
