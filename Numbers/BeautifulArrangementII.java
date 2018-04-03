import java.util.*;
import java.io.*;

  public class BeautifulArrangementII { 
	  
    public static int[] constructArray(int number, int k) {
      int[] answer = new int[number];
      int c = 0;
      for (int i = 1; i < number - k; i++) {
        answer[c++] = i;
      }
      for (int i = 0; i <= k; i++) {
	if(i % 2 == 0) {
          answer[c++] = number - k + i/2; // When we are writing the ith element from the remaining k+1, every even i is going to be chosen from the head and we will have (number - k + j/2)
	}
	else {
	  answer[c++] = number - i/2;  // Every odd i is going to be chosen from the tail, and will have value n - i/2.	
	}
      }
		
      return answer;
    }	  

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of different positive integers: ");
      int number = input.nextInt();  
      System.out.println();
      System.out.print("Enter number of distinct integers in the list: ");
      int k = input.nextInt();   
      int list[] = constructArray(number, k);
      System.out.println();
      System.out.print("The list that has exactly " + k + " distinct integers is: "); 
      System.out.print("[");
      for(int i = 0; i < list.length; i++) {
  	System.out.print(list[i] + " ");
      }
      System.out.println("]");
    }
  }
