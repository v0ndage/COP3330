import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;

public class Part4 {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        int choice = 0;

        System.out.print("===========+/-x===========\n");
        System.out.print("Welcome to My Math Program\n");
        System.out.print("===========+/-x===========\n");

        System.out.print("Please Enter Difficulty >>\n");

        while (choice < 1 || choice > 4) {
            System.out.print("\t[1]>>[2]>>[3]>>[4]\n");
            while (!scr.hasNextInt())
                scr.next();
            choice = scr.nextInt();
        }

        while (true){

            int i = 0;
            int correct = 0;

            while (i < 10) {

                int guess;

                System.out.printf("%d)\t", i+1);

                int answer = NewQuestion(choice);

                while (!scr.hasNextInt())
                    scr.next();
                guess = scr.nextInt();

                if (guess != answer) {
                    System.out.printf("%s\n", Response(0));
                } else {
                    System.out.printf("%s\n\n", Response(1));
                    correct++;
                }
                i++;
            }

            if (Feedback(correct) != 1) break;
        }
    }

    static int NewQuestion(int difficulty) {

        SecureRandom rand = new SecureRandom();

        int rand_int1 = 0;
        int rand_int2 = 0;

        switch(difficulty){
            case 1:     rand_int1 = rand.nextInt(9) + 1;
                rand_int2 = rand.nextInt(9) + 1;
                break;
            case 2:     rand_int1 = rand.nextInt(99) + 1;
                rand_int2 = rand.nextInt(99) + 1;
                break;
            case 3:     rand_int1 = rand.nextInt(999) + 1;
                rand_int2 = rand.nextInt(999) + 1;
                break;
            case 4:     rand_int1 = rand.nextInt(9999) + 1;
                rand_int2 = rand.nextInt(9999) + 1;
                break;
        }
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

    static int Feedback(int score){

        score = score * 10;

        System.out.printf("\nYour Score: %d/100\n", score);

        if (score < 75){
            System.out.print("Please ask your teacher for extra help.\n\n\n");
            return 0;
        }
        else {
            System.out.print("Congratulations, you are ready to go to the next level!\n\n\n");
            return 1;
        }
    }
}