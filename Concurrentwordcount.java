import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class WordCount extends Thread {
    String filepath;
    WordCount(String filepath) {
        this.filepath = filepath;
    }
    public void run() {
        int wordcount = 0;
        int linecount = 0;
        int sentencecount = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath)); BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/PRIYANKA/OneDrive/Desktop/Output.txt",true))) {
            String line;
            while ((line=br.readLine()) != null) {
                String[] words = line.split("\\W+");
                wordcount+=words.length;
                linecount+=1;
                String[] sentences = line.split("[.!?]");
                sentencecount+=sentences.length;
            }
            bw.write(filepath+" Word count is "+wordcount+"\n"+"Sentence count is "+sentencecount+"\n"+"Line count is "+linecount+"\n");
        } catch (IOException e){
            System.out.println("File not found");
           } //finally {
        //     System.out.println("Word count is "+wordcount+"\n"+"Sentence count is "+sentencecount+"\n"+"Line count is "+linecount+"\n");
        // }
    }
}
public class Concurrentwordcount {
    public static void main(String[] args) {
        WordCount t1 = new WordCount("C:/Users/PRIYANKA/OneDrive/Desktop/File1.txt");
        WordCount t2 = new WordCount("C:/Users/PRIYANKA/OneDrive/Desktop/File2.txt");
        t1.start();
        t2.start();
    }
}
