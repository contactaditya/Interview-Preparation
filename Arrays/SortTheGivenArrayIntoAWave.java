import java.util.*;
import java.io.*;

  public class SortTheGivenArrayIntoAWave {
	  
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
	  Collections.sort(a);	
	  int n = a.size();
	  for (int i = 2; i <= n; i += 2) {
	    exchange(a, i - 2, i - 1);
	  }

	  return a;
    }		
	
	public static void exchange(ArrayList<Integer> a, int i, int j) {
	  int temp = a.get(i);
	  a.set(i, a.get(j));
	  a.set(j, temp);
	}		  

    public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  ArrayList<Integer> numbers = new ArrayList<>();	
	  ArrayList<Integer> result = new ArrayList<>();	
		
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < number; i++) {
		numbers.add(input.nextInt());
	  }
	  
	  result = wave(numbers);
	    
	  System.out.println();	
	  System.out.print("The elements in the wave sequence are: " + result);
			
	}
  } 
