import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();

        try (BufferedReader bfr =
                    new BufferedReader(
                            new FileReader("textInput.txt"))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Adding the input to the list
                    wordsList.add(String.format("\"%s\"", word));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try (PrintWriter pw =
                     new PrintWriter(
                             new FileWriter("textOutput.txt"))) {
            // The result output
            String result = String.join(", ", wordsList);
            pw.write(result);
            System.out.println(wordsList);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
