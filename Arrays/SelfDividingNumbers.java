import java.util.*;
import java.io.*;

 public class SelfDividingNumbers {
	 
    public static List<Integer> selfDividingNumbers(int left, int right) {
       List<Integer> answer = new ArrayList<Integer>();	
       for (int number = left; number <= right; number++) {
         if(selfDividing(number)) {
           answer.add(number);
         }
       }
       return answer;     
    }	 

    private static boolean selfDividing(int number) {
       int x = number;
       while (x > 0) {
	 int d = x % 10;
	 x /= 10;
	 if (d == 0 || (number % d) > 0) {
	   return false;
	 }
       }
       return true;
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the lower bound for the numbers: ");
      int left = input.nextInt();  
		
      System.out.println();	
      System.out.print("Enter the upper bound for the numbers: ");
      int right = input.nextInt();  
		  
      List<Integer> result = new ArrayList<Integer>();	
      result = selfDividingNumbers(left, right); 
      System.out.println();
      System.out.println("The list of every possible self dividing number including the lower and upper number bound is: " + result);
    }
 }
