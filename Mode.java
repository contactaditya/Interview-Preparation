import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Mode {
	
  public static long calculateMode(long[] array) {

    int n = array.length;  
    long mode = 0;
    int counter = 0;
    int max_counter = 0;
				     
    for(int i=1;i<n;i++) {

     if(array[i-1] == array[i]) {
      counter++;
     }

     if(array[i-1] != array[i]) {
      counter = 1;
     }

     if(counter > max_counter) {
      mode = array[i];
      max_counter = counter;
     }

   }

    return mode;
  }	
	  
  public static void main(String[] args) throws NumberFormatException, IOException {
		
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int numbers = input.nextInt();    
	long array[] = new long[numbers];
	    
	System.out.print("\n");
    System.out.print("Please enter the actual values in the array: ");
	for (int i = 0; i < numbers; i++) {
	  array[i] = input.nextInt();   
	}
		
	System.out.print("\n");
		
	System.out.print("The actual values in the array are: ");
	for (int i = 0; i < numbers; i++) {
	  System.out.print(array[i] + " ");
	}  
		
	System.out.print("\n \n");
		
	Arrays.sort(array);
		
	System.out.print("The sorted values in the array are: ");
		
	for (Long i : array) {
	  System.out.print(i.intValue() + " ");
	}
		  	
	long mode = calculateMode(array);
	    
	System.out.print("\n \n");
	    
	System.out.println("The value of the mode of the array is: " + mode);

   }
 }