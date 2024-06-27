import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//imports


public class WordCounter {

    // Function to count words in a document
    //Receive the file name and return a map with the words count
    public static Map<String, Integer> countWords(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        //We use the BufferedReader and Filereader to read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //This part we read the file linbe by line and use split to split in words
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Increment word count
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        //We handle exceptions that may occur when opening or reading the file.
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String filename = args[0];

        Map<String, Integer> wordCount = countWords(filename);

        // Display word counts
        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
