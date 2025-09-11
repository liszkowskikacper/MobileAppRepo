import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class zad2 {

    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("przyklad.txt");
        Scanner myReader = new Scanner(plik);
        int czyn = 0;
        int liczba = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            int numb = Integer.parseInt(data);
            int numbb = numb;
            List<Integer> factors = new ArrayList<Integer>();
            for (int i = 2; i <= numbb; i++) {
                while (numbb % i == 0) {
                    factors.add(i);
                    numbb /= i;
                }
            }
            if (factors.size() > czyn){
                czyn = factors.size();
                liczba = numb;
            }
        }
        myReader.close();
        System.out.print(liczba);
        System.out.print(" ");
        System.out.print(czyn);
    }
}
