import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

            System.out.print("Enter a word to search for: ");
            String searchWord = scanner.nextLine();

            int searchWordCount = searchWordInFile(filePath, searchWord);
            System.out.println("The word \"" + searchWord + "\" appears " + searchWordCount + " times.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static int searchWordInFile(String filePath, String searchWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while searching the file: " + e.getMessage());
        }
        return count;
    }
}
