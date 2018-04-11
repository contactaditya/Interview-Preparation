import java.util.*;
import java.io.*;

 public class DailyTemperatures {
	   
   public static int[] dailyTemperatures(int[] temperatures) {
     int[] answer = new int[temperatures.length];
     java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
     for(int i = 0; i < temperatures.length; i++) {
       while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	 int index = stack.pop();	
 	 answer[index] = i - index;
       }
       stack.push(i);
     }
     return answer;  
   }  

   public static void main(String[] args) { 	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of elements in the array: ");
     int number = input.nextInt();  
     int temperatures[] = new int[number];
	
     System.out.println();	
     System.out.print("Please enter the elements of the array: ");
     for (int i = 0; i < temperatures.length; i++) {
       temperatures[i] = input.nextInt();
     }
	  
     int result[] = dailyTemperatures(temperatures);
     System.out.println();
     System.out.print("The number of days we have to wait until a warmer temperature are: ");
     for(int i = 0; i < result.length; i++) {
       System.out.print(result[i] + " ");
     }
   }
 }
