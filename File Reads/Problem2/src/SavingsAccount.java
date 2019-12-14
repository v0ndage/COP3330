import java.util.Scanner;
//simulating simple and compound interest
public class SavingsAccount {

    private static double initialDeposit;
    private static double balance;
    private static double annualInterestRate;
    private static double monthlyInterest;
    private static double compoundInterestRate;

    public static void main(String[] args) {

        double saver1 = 2000.00;
        double saver2 = 3000.00;

        /*
        System.out.print("Enter Initial Deposit\n");
        initialDeposit = getValue();
        balance = initialDeposit;

        System.out.print("Enter Annual Simple Interest Rate [as decimal]\n");
        annualInterestRate = getValue();

        System.out.print("Enter Annual Compound Interest Rate [as decimal]\n");
        compoundInterestRate = getValue();
        */

        initialDeposit = balance = 2000.00;

        for (int j = 0; j < 2; j++) {

            for (int y = 0; y < 10; y++) {
                System.out.printf("\nYear %2d, monthly interest - 4%% & 5%%, balance $%.2f\n", y, balance);
                for (int m = 1; m <= 12; m++) {
                    modifyInterestRate(0.04);
                    calculateMonthlyInterest();
                    System.out.printf("\tMonth %2d,\tB: $%.2f @ %.2f\t", m, balance, monthlyInterest);

                    modifyInterestRate(0.05);
                    calculateMonthlyInterest();
                    System.out.printf("\tB: $%.2f @ %.2f\n", balance, monthlyInterest);


                }
                //modifyInterestRate(annualInterestRate += compoundInterestRate);
            }

            System.out.print("\n");
            initialDeposit = balance = 3000.00;
        }
    }
    /*
    public static double getValue() {
        Scanner scr = new Scanner(System.in);
        while (!scr.hasNextDouble())
            scr.next();
        return scr.nextDouble();
    }*/

    public static void calculateMonthlyInterest(){
        monthlyInterest = balance * annualInterestRate / 12.0;
        balance += monthlyInterest;
    }

    public static void modifyInterestRate(double newAnnualRate){
        annualInterestRate = newAnnualRate;
    }
}
