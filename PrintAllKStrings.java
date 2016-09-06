import java.io.*;
import java.util.*;

public class PrintAllKStrings {  
	
  public static void printAllKLength(char array[], int number) { 
	int n = array.length;	 
	printAllKLengthRecursion(array, "", n, number);
  }

  public static void printAllKLengthRecursion(char array[], String prefix, int n, int number) { 
	  
   // Base case: number is 0, print prefix
   if (number == 0) {
	System.out.println(prefix);
	return;
   }

   // One by one add all characters from set and recursively call for number equals to number-1
   for (int i = 0; i < n; ++i) {
			
   // Next character of input added
   String newPrefix = prefix + array[i]; 
			
   // number is decreased, because we have added a new character
   printAllKLengthRecursion(array, newPrefix, n, number - 1); 
  }
 }  
  
  public static void main(String[] args) {    
  
	Scanner input = new Scanner(System.in);
    System.out.print("Enter number of characters in the set: ");
    int number = input.nextInt();  
    char array[] = new char[number];
  
    System.out.println();	
    System.out.print("Please enter the actual characters: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = input.next().charAt(0);
    }
    
    System.out.println();	
    Scanner input1 = new Scanner(System.in);
    System.out.print("Enter the possible length of the string that can be formed from the set: ");
    int number1 = input.nextInt();  
    System.out.println();	
	   	
    printAllKLength(array, number1);
		   
	}     
  }