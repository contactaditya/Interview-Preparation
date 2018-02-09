import java.util.*;
import java.io.*;

  public class MaximumProductOfWordLengths {
	  
    public static int maxProduct(String[] words) {
       if (words == null || words.length == 0) {
	 return 0;	
       }
       int[] value = new int[words.length];
       for (int i = 0; i < words.length; i++) {
	 String temp = words[i];
	 value[i] = 0;
	 for (int j = 0; j < temp.length(); j++) {
	   value[i] |= 1 << (temp.charAt(j) - 'a');
	 }
       } 
       int maxProduct = 0;
       for (int i = 0; i < words.length; i++) {
	 for (int j = i + 1; j < words.length; j++) {
	   if ((value[i] & value[j]) == 0) {
	     maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
	   }
         }
       }	
       return maxProduct;      
    }	  

    public static void main(String[] args) {  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the array: ");
       int numbers = input.nextInt();   
       String words[] = new String[numbers];
		    
       System.out.println();
       input.nextLine();
       System.out.print("Please enter the actual values in the array: ");
       System.out.println();
       for (int i = 0; i < numbers; i++) {
	 words[i] = input.nextLine(); 
       }
	 
       int maxProduct = maxProduct(words);
       System.out.println();
       System.out.print("The maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters is: " + maxProduct);
    }
  }
