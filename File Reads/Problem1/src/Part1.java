import java.util.Scanner;
import java.security.SecureRandom;

public class Part1 {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int i = 0;

        while (i < 100) {

            int strikes = 0;
            int answer = NewQuestion();

            while (strikes < 10) {

                int guess;
                while (!scr.hasNextInt())
                    scr.next();
                guess = scr.nextInt();

                if (guess != answer) {
                    System.out.printf("No. Keep trying!\n");
                } else {
                    System.out.printf("Great job!\n\n");
                    break;
                }
                strikes++;
            }
            i++;
        }
    }

    static int NewQuestion() {

        SecureRandom rand = new SecureRandom();

        int rand_int1 = rand.nextInt(9) + 1;
        int rand_int2 = rand.nextInt(9) + 1;

        System.out.printf("How much is %d times %d?\n", rand_int1, rand_int2);

        return rand_int1 * rand_int2;
    }
}