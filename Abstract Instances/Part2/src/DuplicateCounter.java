import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DuplicateCounter {

    static Integer[] wordCounter;
    static String[] uniqueWords;

    public static void count(Path dataFile){

        String content = null;              //saves input as one string

        try {content = Files.readString(dataFile, StandardCharsets.ISO_8859_1);}   //encoding should be checked

        catch (IOException ex){System.out.println (ex.toString());}

        finally {
            if (content != null) {

                content = content.replaceAll("\\p{P}", "");       //remove punctuation
                content = content.replaceAll("\n", "");           //remove line-breaks

                String[] words = content.split(" ");                         //string to array, delineated by spaces
                Arrays.sort(words);                                                 //alphabetise

                Map<String, Integer> map = new LinkedHashMap<String, Integer>();

                int i=0;

                for (String word : words) {
                    Integer j = map.get(word);
                    map.put(word, (j == null) ? 1 : j + 1);
                }

                ArrayList<String> keyList = new ArrayList<String>(map.keySet());
                ArrayList<Integer> valueList = new ArrayList<Integer>(map.values());

                String[] resultWords = new String[keyList.size()];                           //new array of unique strings
                uniqueWords = keyList.toArray(resultWords);

                Integer[] resultVals = new Integer[valueList.size()];                           //new array of unique strings
                wordCounter = valueList.toArray(resultVals);

            }
            else {System.out.println("Empty Input");}
        }
    }

    public static void write(Path outputFile){

        File outPath = new File(outputFile.toString());

        try{FileWriter out = new FileWriter(outPath);

            out.write("UNIQUE WORDS AND COUNT\n\n");

            for (int i=0; i<uniqueWords.length; i++){

                out.write(uniqueWords[i] + " : " + wordCounter[i] + "\n");
            }
            out.close();
        }

        catch (IOException ex){System.out.println (ex.toString());}
    }

    public static void checkPath() {
        String absPath = new File("").getAbsolutePath();
        System.out.println("\nYour Absolute Path: " + absPath);
        System.out.println("Files in Path:");
        File file = new File(".");
        for (String fileNames : file.list()) System.out.println("\t" + fileNames);
    }

    public static void main(String[] args) {}       //still learning javaFX application extensions

}