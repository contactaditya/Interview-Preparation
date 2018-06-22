import java.util.*;
import java.io.*;

 public class FindWhetherANumberIsColorfulOrNot {
	 
    public static int colorful(int a) {
      HashSet<Integer> hashSet = new HashSet<>();
      ArrayList<Integer> numbers = new ArrayList<>();
      while (a != 0) {
	int num = a % 10;
	numbers.add(num);
	a /= 10;
      }
	  
      Collections.reverse(numbers);
	  
      // The first loop picks the starting point. The second loop picks the ending point. 
	  
      for (int i = 0; i < numbers.size(); i++) {
	for (int j = i; j < numbers.size(); j++) {
	  int product = 1;
	  for (int k = i; k <= j; k++) {
            product *= numbers.get(k);
          }
	  if (hashSet.contains(product)) {
            return 0;
	  }
	  hashSet.add(product);	
	}
      }
		
      return 1;
    }	 
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = input.nextInt();
      int result = colorful(number);
      System.out.println();
      if(result == 1) {
	System.out.println("This number is a colorful number.");  
      }
      else {
	System.out.println("This number is not a colorful number.");  
      }
    }
  }
