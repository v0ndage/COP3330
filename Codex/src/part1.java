import java.util.Scanner;

public class part1 {
	
	public static void main(String[] args) {
		
		int max = 4;						//max ints for code
		
		System.out.printf("\nPlease input code:\n");
		Scanner input = new Scanner(System.in);

		String code = input.next();			//code is initially read as a string, so as to make validation easier			
		int digits = code.length();			//code is later converted into int array for encoding / decoding
		
		if (digits != max) {
			System.out.printf("%d Digits Please\n", max); System.exit(1);
		}
		
		for (int i = 0; i < digits; i++) {
			if ((int)code.charAt(i) < 48 || (int)code.charAt(i) > 57) {	//checks for digits 0 - 9
				System.out.println("Only Digits Please"); System.exit(1);
			}
		}
		
		decode(encode(str2array(code, digits)));	//main call
		input.close();
		return;
	}
	
	static int[] str2array(String str, int size) {
		
		int[] array = new int[size + 1];
		
		for (int i = 0; i < size; i++)
		        array[i] = (str.charAt(i) - '0');

		return array;
	}
	
	static int[] encode(int[] num) {
    	
    	num[0] = (num[0] + 7) % 10;
    	num[1] = (num[1] + 7) % 10;
    	num[2] = (num[2] + 7) % 10;
    	num[3] = (num[3] + 7) % 10;
    	
		int swap;
    	
    	swap = num[0];
    	num[0] = num[2];
    	num[2] = swap;
    	
    	swap = num[1];
    	num[1] = num[3];
    	num[3] = swap;
    	
    	System.out.print("Ecoded Input: ");
    	for (int i=0; i<4; i++) {
        	System.out.printf("%d", num[i]);
    	}
       	System.out.printf("\n");
       	
       	return num;
    }

	static void decode(int[] num) {

		int swap;
    	
    	swap = num[0];
    	num[0] = num[2];
    	num[2] = swap;
    	
    	swap = num[1];
    	num[1] = num[3];
    	num[3] = swap;

    	num[0] = (num[0] + 3) % 10;
       	num[1] = (num[1] + 3) % 10; 
    	num[2] = (num[2] + 3) % 10; 
    	num[3] = (num[3] + 3) % 10; 

		System.out.print("Decoded Input: ");
    	for (int i=0; i<4; i++) {
        	System.out.printf("%d", num[i]);
    	}
       	System.out.printf("\n");	
	}
}