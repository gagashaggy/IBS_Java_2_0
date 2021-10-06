import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Task 6
 *
 * @author vmokhnachev
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(Main.class.getClassLoader().getResource("task.txt").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        reader.close();
        List<String> words = new ArrayList<String>(Arrays.asList(line.split(" ")));
        System.out.println("Reading words from the file:\n");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("\nSorted list:\n");
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
        Map<String, Integer> stats = new TreeMap<String, Integer>();
        for (String word : words) {
            if (!stats.containsKey(word))
                stats.put(word, 1);
            else stats.put(word, stats.get(word) + 1);
        }
        System.out.println("\nStatistics:\n");
        for (String word : stats.keySet()) {
            System.out.println(word + ": " + stats.get(word));
        }
        int maxFrequency = 0;
        for (String word : stats.keySet()) {
            if (stats.get(word) > maxFrequency)
                maxFrequency = stats.get(word);
        }
        List<String> mostFrequentWords = new ArrayList<String>();
        for (String word : stats.keySet()) {
            if (stats.get(word) == maxFrequency)
                mostFrequentWords.add(word);
        }
        System.out.print("\nMost frequent word(s):\n");
        for (String word : mostFrequentWords) {
            System.out.println(word);
        }
        System.out.println();
        System.out.println("Frequency: " + maxFrequency);
    }
}
