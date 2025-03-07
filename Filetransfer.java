import java.io.*;

class AddFile extends Thread{
    String filepath;
    AddFile(String filepath) {
        this.filepath = filepath;
    }
    public void run() {
        File folder = new File("C:/Users/PRIYANKA/OneDrive/Desktop/Java programs/Files");
        File file = new File(folder,filepath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
public class Filetransfer {
    public static void main(String[] args) {
        AddFile a1 = new AddFile("a.txt");
        AddFile a2 = new AddFile("b.txt");
        a1.start();
        a2.start();
    }
}
