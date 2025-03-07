import java.io.*;
import java.util.HashMap;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        HashMap<String,Integer> freq = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/Priyanka/OneDrive/Desktop/Java programs/Files/a.txt"))){
            String line;
            while ((line=br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for(int i = 0;i<words.length;i++) {
                    if(freq.containsKey(words[i])) {
                        freq.put(words[i],freq.get(words[i])+1);
                    } else {
                        freq.put(words[i], 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (String key : freq.keySet()) {
            System.out.println(key+" : "+freq.get(key));
        }
    }
}
