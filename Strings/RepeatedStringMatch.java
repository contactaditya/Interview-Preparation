import java.util.*;
import java.io.*;

 public class RepeatedStringMatch {
	 
    public static int repeatedStringMatch(String A, String B) {
       StringBuilder string = new StringBuilder();
       string.append(A);
       int count = 1;
       while(string.indexOf(B) < 0) {
        string.append(A);
        if(string.length() > B.length() && string.indexOf(B) < 0) {
          return -1;
        }
        count++;   
       }
       return count;  
    }	 

    public static void main(String[] args) {  
       String A = new String();	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the first string: ");
       A = input.next();  
	   
       System.out.println();	
       String B = new String();	  
       System.out.print("Enter the second string: ");
       B = input.next();
	  
       int minimumNumberOfTimes = repeatedStringMatch(A, B);
       System.out.println();	
       System.out.println("The minimum number of times " + A + " has to be repeated such that " + B + " is a substring of it is: " + minimumNumberOfTimes);	
    }
 }
