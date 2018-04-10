import java.util.*;
import java.io.*;

 public class InterleavingString {
	
   public static boolean isInterleave(String string1, String string2, String string3) {
     if ((string1.length() + string2.length()) != string3.length()) {
       return false;
     }
     boolean[][] matrix = new boolean[string2.length()+1][string1.length()+1];
     matrix[0][0] = true;
     for (int i = 1; i < matrix[0].length; i++) {
       matrix[0][i] = matrix[0][i-1] && (string1.charAt(i-1) == string3.charAt(i-1));
     }
     for (int i = 1; i < matrix.length; i++) {
       matrix[i][0] = matrix[i-1][0] && (string2.charAt(i-1) == string3.charAt(i-1));
     }

     for (int i = 1; i < matrix.length; i++) {
       for (int j = 1; j < matrix[0].length; j++) {
	 matrix[i][j] = (matrix[i-1][j] && (string2.charAt(i-1) == string3.charAt(i+j-1))) || (matrix[i][j-1] && (string1.charAt(j-1) == string3.charAt(i+j-1)));
       }
     }	   

     return matrix[string2.length()][string1.length()];  
   }	 

   public static void main(String[] args) {   
     String string1 = new String();	
     String string2 = new String();	
     String string3 = new String();	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the first string: ");
     string1 = input.nextLine(); 
     System.out.println();
     System.out.print("Enter the second string: ");
     string2 = input.nextLine(); 
     System.out.println();
     System.out.print("Enter the third string: ");
     string3 = input.nextLine(); 
     System.out.println();
	  
     if(isInterleave(string1, string2, string3)) {
       System.out.println("The string " + string3 + " is formed by the interleaving of " +  string1 + " and " + string2);
     }
     else {
       System.out.println("The string " + string3 + " is not formed by the interleaving of " +  string1 + " and " + string2);  
     }
   }
 }
