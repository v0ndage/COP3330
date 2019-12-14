import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) {

        Path input = Paths.get("problem2.txt");
        Path output = Paths.get("unique_word_counts.txt");

        DuplicateCounter.checkPath();

        DuplicateCounter.count(input);

        DuplicateCounter.write(output);
    }
}