import java.util.ArrayList;
import java.util.Scanner;

public class EquilibriumIndexOfAnArray {
 
 public static void equilibrium(int array[]) {
  int sum = 0;	 
  int leftsum = 0;

  for(int i = 0; i < array.length; i++) {
	sum = sum + array[i];  
  }
  
  System.out.print("The numbers that satisfy the equilibrium index are: ");
  
  for(int i = 0; i < array.length; i++) {
	sum = sum - array[i]; 
	 
	if(leftsum == sum) {
	  System.out.print(array[i] + " ");
	}
	
	leftsum = leftsum + array[i];		 
  }
 }
 
  public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
   System.out.print("Enter number of elements in the array: ");
   int number = input.nextInt();  
   int array[] = new int[number];
	  
   System.out.println();	
   System.out.print("Please enter the actual numbers in the array: ");
   for (int i = 0; i < array.length; i++) {
	 array[i] = input.nextInt();
   }
   System.out.println();	
   equilibrium(array);  
 }
}
