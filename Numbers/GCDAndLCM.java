import java.io.*;
import java.util.*;

public class GCDAndLCM {  
	
  public static int findGCD(int number1, int number2) {
    if (number2 == 0) {
      return number1;  
    }  
    return findGCD(number2, number1%number2);			
  }
 
  public static int findLCM(int number1, int number2) {
     return (number1 * number2)/findGCD(number1, number2);		
  }
  	
 public static void main(String[] args) throws NumberFormatException, IOException {
     int choice = 0;
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the first number: ");
     int number1 = input.nextInt();  
     System.out.println();	
     Scanner input1 = new Scanner(System.in);
     System.out.print("Enter the second number: ");
     int number2 = input1.nextInt();  
     System.out.println();	
		    
     do{	
        System.out.println("1. To calculate the gcd of the numbers.");
        System.out.println("2. To calculate the lcm of the numbers.");
        System.out.println("3. For exiting from the program.");
		   
        System.out.println();	
		    	 
        System.out.print("Enter your choice: ");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  
        choice = Integer.parseInt(br1.readLine());
        switch (choice) {
           case 1:  int gcd = findGCD(number1, number2);
	            System.out.println();	
	   	    System.out.println("The GCD of the two numbers is: " + gcd);
		    break;
           case 2:  int lcm = findLCM(number1, number2);
	   	    System.out.println();	
	   	    System.out.println("The LCM of the two numbers is: " + lcm);
		    break;    
        }
       System.out.print("\n");
    } while(choice!=3);	  
  }
}
