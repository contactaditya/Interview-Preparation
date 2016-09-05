import java.io.IOException;
import java.util.Scanner;

public class SubsetSum { 
 
  public static boolean SubsetSum(int[] array, int sum) {
	  
  int n = array.length;	  
	
  boolean subset[][] = new boolean[sum + 1][n + 1];   
  
  // In any set there will be empty subset with sum 0.
  
  for(int i = 0; i <= n; i++) {
    subset[0][i] = true;
  }
  
  // We can't find a sum > 0 in an empty array.
  
  for(int s = 1; s <= sum; s++) {
	subset[s][0] = false;
  }
  
  // Fill the subset table in a bottom up manner.
	  
  for(int i = 1; i <= sum; i++) {	  
   for(int j = 1; j <= n; j++) {
	   
    subset[i][j] = subset[i][j-1];
    
     if(i >= array[j-1]) {
      subset[i][j] = subset[i][j] || subset[i - array[j-1]][j-1];
     }    
    }
  }
  return subset[sum][n];
 }	
		
  public static void main(String[] args) throws NumberFormatException, IOException {
	  
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int number = input.nextInt();  
	int array[] = new int[number];
	
	System.out.println();	
	System.out.print("Please enter number: ");
	for (int i = 0; i < array.length; i++) {
	  array[i] = input.nextInt();
	}
	
	Scanner input1 = new Scanner(System.in);
	System.out.println();	
	System.out.print("Enter the sum of subset that you want to check whether it is present in the array or not: ");
	int number1 = input1.nextInt();  
		
	boolean max = SubsetSum(array, number1);
	System.out.print("\n");
	
	if(max) {
      System.out.println("The array contains a subset with the sum: " + number1);	
	}
	else {
	  System.out.println("The array does not contain a subset with the sum: " + number1);	
	}
  }     
}