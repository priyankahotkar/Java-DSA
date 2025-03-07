import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyThread extends Thread {
    String filepath;
    String outputfile;
    MyThread(String filepath,String outputfile) {
        this.filepath = filepath;
        this.outputfile = outputfile;
    }
    public void run() {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile,true));
        try(BufferedReader br = new BufferedReader(new FileReader(filepath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile,true))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line+"\n");
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
public class ConcurrentFileProcessing {
    public static void main(String[] args) {
        //File outputFile = new File("C:/Users/PRIYANKA/OneDrive/Desktop");
        MyThread t1 = new MyThread("C:/Users/PRIYANKA/OneDrive/Desktop/File1.txt", "C:/Users/PRIYANKA/OneDrive/Desktop/Output.txt");
        MyThread t2 = new MyThread("C:/Users/PRIYANKA/OneDrive/Desktop/File2.txt", "C:/Users/PRIYANKA/OneDrive/Desktop/Output.txt");
        t1.start();
        t2.start();

    }
}
