import java.util.*;
import java.io.*;

  public class MagicalString {
	  
    public static int magicalString(int number) {
      if (number <= 0) {
	 return 0;
      }
      if (number <= 3) {
	 return 1;	
      }
      int array[] = new int[number + 1];
      array[0] = 1; array[1] = 2; array[2] = 2;
      int head = 2, tail = 3, value = 1, count = 1;
      while (tail < number) {
        for (int i = 0; i < array[head]; i++) {
          array[tail] = value;
          if (value == 1 && tail < number) {
      	    count++;
          }
          tail++;
        }
        // A trick to flip number back and forth between 1 and 2: value = value ^ 3
        value = value ^ 3;
        head++;
      }
      
      return count;      
    }	  

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
	 
      int numberOfOnes = magicalString(number);
      System.out.println();
      System.out.print("The number of '1's in the first " + number + " in the magical string S: " + numberOfOnes);
    }
  }
