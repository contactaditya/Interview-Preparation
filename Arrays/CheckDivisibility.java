import java.util.*;
import java.io.*;

  public class CheckDivisibility {

   public static List<Integer> keepDivisible(List<Integer> list, int m, int n) {
	  List<Integer> result = new ArrayList<Integer>();
	  for (int i = 0; i < list.size(); i++) { 		      
        if(list.get(i) % m == 0 && list.get(i) % n != 0) {
          result.add(list.get(i));   
        } 		
      }   		
	 
	  return result;   
	}	  

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      List<Integer> list = new ArrayList<Integer>();	
 			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
 	    list.add(input.nextInt());
      }
        
 	  System.out.println();
 	  System.out.print("Enter a positive integer m: ");
 	  int m = input.nextInt();  
 	   
 	  System.out.println();
 	  System.out.print("Enter a positive integer n: ");
 	  int n = input.nextInt();  
 	   
 	  List<Integer> result = new ArrayList<Integer>();
 	   
 	  result = keepDivisible(list, m, n);
 	  System.out.println();
 	  System.out.print("The list of integers which are divisible by " + m + " but not divisible by " + n + " in the list are: " + result);
    }
  }