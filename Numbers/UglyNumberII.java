import java.util.*;
import java.io.*;

 public class UglyNumberII {
	
   public static int nthUglyNumber(int number) {
      if (number <= 0) {
	return 0;
      }      
      List<Integer> list = new ArrayList<>();
      list.add(1);
      int i=0, j=0, k=0;
      while(list.size() < number) {
    	int m2 = list.get(i)*2;
        int m3 = list.get(j)*3;
        int m5 = list.get(k)*5;  
        
        int min = Math.min(m2, Math.min(m3, m5));
        list.add(min);
        
        if(min==m2) {
           i++;
        }
 
        if(min==m3) {
           j++;
        }
 
        if(min==m5) {
           k++;
        }
      }
		  
      return list.get(list.size()-1);
   }	 

   public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
      int isTheNumberUgly = nthUglyNumber(number);
      System.out.println();
      System.out.println(number + "th ugly number is " + isTheNumberUgly);  
   }
 } 
