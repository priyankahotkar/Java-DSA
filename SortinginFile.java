import java.io.*;
import java.util.*;

class Sorting extends Thread {
    String filepath;
    String outputfilepath;
    Sorting(String filepath, String outputfilepath) {
        this.filepath = filepath;
        this.outputfilepath = outputfilepath;
    }
    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader(filepath)) ; BufferedWriter bw = new BufferedWriter(new FileWriter(outputfilepath,true))) {
            String line;
            while ((line=br.readLine()) != null) {
                String[] words = line.split("\\s+");
                Arrays.sort(words,String.CASE_INSENSITIVE_ORDER);
                String sortedWords = String.join(" ",words);
                bw.write(sortedWords);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
public class SortinginFile {
    public static void main(String[] args) {
        Sorting s1 = new Sorting("C:/Users/PRIYANKA/OneDrive/Desktop/File1.txt", "C:/Users/PRIYANKA/OneDrive/Desktop/Output4.txt");
        Sorting s2 = new Sorting("C:/Users/PRIYANKA/OneDrive/Desktop/File2.txt", "C:/Users/PRIYANKA/OneDrive/Desktop/Output5.txt");
        s1.start();
        s2.start();
    }
}
