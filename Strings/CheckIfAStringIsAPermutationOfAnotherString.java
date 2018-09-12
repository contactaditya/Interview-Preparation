import java.util.*;
import java.io.*;

 public class CheckIfAStringIsAPermutationOfAnotherString {
	 
   public static boolean checkInclusion(String s1, String s2) {
     if(s1.length() > s2.length()) {
       return false;	
     }
     int[] count = new int[26];
     char[] array1 = s1.toCharArray();
     for(int i=0; i < array1.length; i++) {
       count[array1[i]-'a']++;
     }
     char[] array2 = s2.toCharArray();
     int start = 0;
      
     for(int i = 0; i < array2.length; i++) {
       count[array2[i]-'a']--;
          
       while(count[array2[i]-'a'] < 0) {
         count[array2[start]-'a']++;
         start++;
       }
          
       if(i - start + 1 == array1.length) {
         return true;
       }
     }
     
     return false;     
   }	  

   public static void main(String[] args) {   
     String smallString = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the smaller string: ");
     smallString = input.nextLine(); 
	  
     System.out.println();
	  
     String largeString = new String();	  
     System.out.print("Enter the second string: ");
     largeString = input.nextLine(); 
	  
     boolean checkPermutation = checkInclusion(smallString, largeString);
	 
     System.out.println();
	  
     if(checkPermutation) {
       System.out.print(largeString + " contains one permutation of " + smallString);
     } else {
       System.out.println(largeString + " does not contain any permutation of " + smallString);  
     }
   }
 }
