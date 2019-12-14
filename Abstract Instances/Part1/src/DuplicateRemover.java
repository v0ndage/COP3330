import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemover {

    static String[] uniqueWords;            //saves unique words from input as array of strings

    public static void remove(Path dataFile) {

        String content = null;              //saves input as one string

        try {content = Files.readString(dataFile, StandardCharsets.ISO_8859_1);}   //encoding should be checked

        catch (IOException ex){System.out.println (ex.toString());}

        finally {
            if (content != null) {

                content = content.replaceAll("\\p{P}", "");        //remove punctuation
                content = content.replaceAll("\n", "");            //remove line-breaks

                String[] words = content.split(" ");                          //string to array, delineated by spaces
                Arrays.sort(words);                                                 //alphabetise

                Set<String> set = new LinkedHashSet<String>(Arrays.asList(words));  //hash set removes duplicates
                String[] unique = new String[set.size()];                           //new array of unique strings
                uniqueWords = set.toArray(unique);                                  //hash set to string array
            }
            else {System.out.println("Empty Input");}
        }
    }

    public static void write(Path outputFile){

        File outPath = new File(outputFile.toString());

        try{FileWriter out = new FileWriter(outPath);

            out.write("UNIQUE WORDS\n");
            for (String word : uniqueWords) out.write(word + "\n");
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