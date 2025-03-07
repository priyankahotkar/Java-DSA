import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryLister {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Change this to your directory path
        listFilesAndSubdirectories(directoryPath);
    }

    public static void listFilesAndSubdirectories(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            try (BufferedWriter fileWriterA = new BufferedWriter(new FileWriter("A.txt"));
                 BufferedWriter fileWriterB = new BufferedWriter(new FileWriter("B.txt"))) {

                for (File file : files) {
                    if (file.isFile()) {
                        fileWriterA.write(file.getName() + "\n");
                    } else if (file.isDirectory()) {
                        fileWriterB.write(file.getName() + "\n");
                    }
                }
                System.out.println("File and directory names written to A.txt and B.txt respectively.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory is empty or does not exist.");
        }
    }
}
