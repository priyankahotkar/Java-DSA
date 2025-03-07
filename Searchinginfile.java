import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SearchPattern extends Thread {
    String filePath;
    boolean flag;
    SearchPattern(String filePath) {
        this.filePath = filePath;
    }
    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader(this.filePath)) ; BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/PRIYANKA/OneDrive/Desktop/Output3.txt",true))) {
            String line;
            while ((line=br.readLine()) != null) {
                if (line.contains("the")) {
                    bw.write(line.replace("the", "an"));
                    this.flag = true;
                }
                else {
                    bw.write(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
public class Searchinginfile {
    public static void main(String[] args) throws InterruptedException {
        SearchPattern t1 = new SearchPattern("C:/Users/PRIYANKA/OneDrive/Desktop/File1.txt");
        SearchPattern t2 = new SearchPattern("C:/Users/PRIYANKA/OneDrive/Desktop/File2.txt");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Pattern found "+t1.flag);
        System.out.println("Pattern found "+t2.flag);
    }
}
