import java.util.Scanner;

public class part2 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("This program calculates BM from Height and Weight inputs.\n\nType \"1\" for Metric (meters & kilograms)\nType \"2\" for Imperial (inches & pounds)\n");

		int unit = 0;
		
		while (unit != 1 && unit != 2) {			//scan until find proper choice
			
			while (!input.hasNextInt())
				input.next();
			unit = input.nextInt();
		}
		
		if (unit == 1)
			System.out.println("\n[Metric]");
		if (unit == 2)
			System.out.println("\n[Imperial]");
		
		double height, weight;
		
		System.out.print("\nPlease Input Height: ");		//scan until find proper height		
		while (!input.hasNextDouble()) {
			System.out.print("(input expects double)");
			input.next();
		}
		height = input.nextDouble();
		if (reasonableHeight(height, unit) != 1) System.out.println("(proceeding with unreasonable height)");

		System.out.print("\nPlease Input Weight: ");		//scan until find proper weight
		while (!input.hasNextDouble()) {
			System.out.print("(input expects double)");
			input.next();
		}
		weight = input.nextDouble();
		if (reasonableWeight(weight, unit) != 1) System.out.println("(proceeding with unreasonable weight)");

		calculateBMI(height, weight, unit);
		
		input.close();
		return;
		
		//END
	}
	
	static void calculateBMI(double h, double w, int u) {
		
		double BMI = 0.0;
		
		if (u == 1) {
			BMI = w / (h * h);
			System.out.printf("BMI = (%.2f [kg]) / (%.2f [m])^2 = %.2f", w, h, BMI);
		}
		if (u == 2) {
			BMI = (707 * w) / (h * h);
			System.out.printf("\nBMI = (%.2f [lbs]) / (%.2f [in])^2 = %.2f", w, h, BMI);
		}
		
		System.out.printf("\n\nAccording to the National Heart Lung and Blood Institute, ");
		
		if (BMI < 18.5) System.out.println("Your BMI indicates \"Underweight\"");
		else if (BMI > 25.0) System.out.println("Your BMI indicates \"Overweight\"");
		else System.out.println("Your BMI indicates \"Normal weight\"");
		
		return;
	}
	
	static int reasonableHeight(double h, int u) {
		if (u == 1)
			return ((h < 0.3) || (h > 2.8)) ? 0 : 1;
		else return ((h < 12) || (h > 108)) ? 0 : 1;
	}
	
	static int reasonableWeight(double w, int u) {
		if (u == 1)
			return ((w < 2.1) || (w > 650)) ? 0 : 1;
		else return ((w < 5) || (w > 1500)) ? 0 : 1;
	}
}