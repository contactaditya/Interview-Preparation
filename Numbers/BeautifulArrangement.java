import java.util.*;
import java.io.*;

  public class BeautifulArrangement {
    static int count = 0; 
	
	public static int countArrangement(int number) {
      boolean visited[] = new boolean[number + 1];
	  calculate(number, 1, visited);
	  return count;      
	}	  

	private static void calculate(int number, int position, boolean[] visited) {
	  if(position > number) {
		count++;  
	  }
	  for(int i = 1; i <= number; i++) {
		if(!visited[i] && (position % i == 0 || i % position == 0)) {
	      visited[i] = true;
	      calculate(number, position + 1, visited);
	      visited[i] = false;
		}
	  }
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	  int numberOfArrangements = countArrangement(number);
	  System.out.println();
      System.out.println("The number of beautiful arrangement that you can construct are: " + numberOfArrangements);  
	}
  }
