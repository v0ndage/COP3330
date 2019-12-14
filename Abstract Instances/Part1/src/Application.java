import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) {

        Path input = Paths.get("problem1.txt");
        Path output = Paths.get("unique_words.txt");

        DuplicateRemover.checkPath();

        DuplicateRemover.remove(input);

        DuplicateRemover.write(output);

    }
}