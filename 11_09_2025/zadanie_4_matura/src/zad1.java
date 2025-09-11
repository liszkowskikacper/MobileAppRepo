import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("liczby.txt");
        Scanner myReader = new Scanner(plik);
        int ile = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            char[] myArray = data.toCharArray();
            char first =  myArray[0];
            char last =   myArray[myArray.length-1];
            if (first == last){
                ile = ile + 1;
            }
        }
        myReader.close();
        System.out.print(ile);
        System.out.print(" ");
        File plik2 = new File("liczby.txt");
        Scanner myReader2 = new Scanner(plik);
        while (myReader2.hasNextLine()) {
            String data2 = myReader2.nextLine();
            char[] myArray2 = data2.toCharArray();
            char first2 =  myArray2[0];
            char last2 =   myArray2[myArray2.length-1];
            if (first2 == last2){
                System.out.print(data2);
                break;
            }
        }
    }
}