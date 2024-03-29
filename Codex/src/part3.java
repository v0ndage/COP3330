import java.util.Scanner;

public class part3 {
	
	public static void main(String[] args) {

	    System.out.printf("On a scale of 1 to 10, please rank the following topics in terms of Importance.\n");
	
	    int choice;		//rankings per topic question
	    int next;		//whether or not another voter chooses to vote
	    int voter = 0;	//number of voters so far
	    
	    String[] topic = new String[5];
	
	    topic[0] = "Java?";					//too brain dead to be creative tonight
	    topic[1] = "dogs?";
	    topic[2] = "gentrification?";
	    topic[3] = "Keanu Reeves?";
	    topic[4] = "Eastern Mysticism?";
	
	    int[][] responses = new int[5][10];
	    
		Scanner input = new Scanner(System.in);
	    	
	    while (voter <= 10) {				//assuming 10 voters max
	    		    		        
	        next = 0;						//new voter loop
	
	        for (int i = 0; i < 5; i++) {
	        	
		        choice = 0;					//new rank loop
	        		            
	            System.out.printf("\n\nTOPIC: %d\t%s\n", i + 1, topic[i]);
	            	            
	            for (int j = 0 ; j < 10; j++)
	            	 System.out.printf("[%d]", j + 1);
    			System.out.println();
	            
	    		while (choice < 1 || choice > 10) {			//scan until find proper choice
	    			while (!input.hasNextInt()) {
	    				System.out.print("Please type an int 1-10");
	    				input.next();
	    			}
	    			choice = input.nextInt();
	    		}
	            responses[i][voter] = choice;	
	        }
	        
	        System.out.printf("\n\nAnyone else wanna vote?\n");
	        System.out.printf("[1 = yes / 2 = no]\n");
	        
			//next = input.nextInt();						//still learning java scanners
	        	        	        
			while (next != 1 && next != 2) {				//scan until find proper choice
				while (!input.hasNextInt()) {
    				System.out.print("Please type 0 or 1");
					input.next();
				}
				next = input.nextInt();
			}
							        
	        if (next == 1) {
		        voter++;
			    System.out.printf("\n\n\n\n\n\n\n\n\n\n");	//trying to "clear screen" for next voter
	        	continue;
	        }
	        else
	            break;
	    }
	    
		input.close();
	    
	    System.out.printf("SUMMARY\n");						//printing results
	    System.out.printf("total voters [%d]\n", voter + 1);
	    
	    for (int i = 0; i < 5; i++) {
	    	System.out.printf("TOPIC [%d] - %s\n", i + 1, topic[i]);
	    	System.out.println("votes:");
	        for (int j = 0; j < voter + 1; j++)   
	        	System.out.printf("%d, ", responses[i][j]);
		    System.out.println();
	    }
	}
}
//END