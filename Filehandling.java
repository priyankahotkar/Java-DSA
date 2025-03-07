import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filehandling {
    public static String reverseWord(String word) {
        String revWord = "";
        for(int i = 0; i<word.length(); i++) {
            revWord += word.charAt(word.length()-1-i);
           }
        return revWord;
    }
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/Priyanka/OneDrive/Desktop/File1.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Priyanka/OneDrive/Desktop/Output2.txt",true))) {
            String line;
            String new_word;
                while ((line=br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String word : words) {
                    new_word = reverseWord(word);
                    bw.write(new_word+" ");
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
