import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;

public class Part2 {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int i = 0;

        while(i<100) {

            int strikes = 0;
            int answer = NewQuestion();

            while (strikes < 10) {

                int guess;
                while (!scr.hasNextInt())
                    scr.next();
                guess = scr.nextInt();

                if (guess != answer) {
                    System.out.printf("%s\n", Response(0));
                } else {
                    System.out.printf("%s\n\n", Response(1));
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

    static String Response(int v) {

        Random rand = new Random();
        int choice = rand.nextInt(3) + 1;
        String resp = "";

        if (v==1){
            switch (choice){
                case 1: resp = "Very good!"; break;
                case 2: resp = "Excellent!"; break;
                case 3: resp = "Nice work!"; break;
                case 4: resp = "Keep up the good work!"; break;
            }
        }
        else {
            switch (choice) {
                case 1: resp = "No. Please try again."; break;
                case 2: resp = "Wrong, try once more."; break;
                case 3: resp = "Don't give up!"; break;
                case 4: resp = "Nope. Keep trying."; break;
            }
        }
        return resp;
    }
}