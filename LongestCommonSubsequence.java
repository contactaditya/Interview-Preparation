import java.util.Scanner;

public class LongestCommonSubsequence { 
 
 public static String LongestCommonSubsequence(String string1, String string2) {
	   
 int lengths[][] = new int[string1.length() + 1][string2.length() + 1]; 
		 
 if (string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0) {
  return "";  
 }
	      
 for(int i = 0; i <= string1.length(); i++) {
  for(int j = 0; j <= string2.length(); j++) {
   if(i == 0 || j == 0) {
	lengths[i][j] = 0;
   }
   else if(string1.charAt(i-1) == string2.charAt(j-1)) {
    lengths[i][j] = lengths[i-1][j-1] + 1; 
   }
   else {
	lengths[i][j] = Math.max(lengths[i-1][j], lengths[i][j-1]); 
   }	
  }
 }
	   
 int i = string1.length();
 int j = string2.length();
	   
 StringBuffer sb = new StringBuffer();
 while(i > 0 && j > 0) {
  if(string1.charAt(i-1) == string2.charAt(j-1)) {
  // Put current character in the string
   sb.append(string1.charAt(i-1));
   i--;
   j--;
  }
  // If the characters are not same, then find the larger of two and go in the direction of larger value
  else if (lengths[i - 1][j] > lengths[i][j - 1]) {
   i--;
  }
 else {
	j--;
  }
 }

 return sb.reverse().toString(); 
 }
		
 public static void main(String[] args) { 
	 
  String string1 = new String();	  
  Scanner input1 = new Scanner(System.in);
  System.out.print("Enter the first string: ");
  string1 = input1.next();  
	  
  System.out.println();	
  String string2 = new String();	  
  Scanner input2 = new Scanner(System.in);
  System.out.print("Enter the second string: ");
  string2 = input2.next();
	  
  String subsequence = LongestCommonSubsequence(string1, string2);
	  
  System.out.println();	
  System.out.println("The longest common subsequence of the two strings is: " + subsequence);	
  System.out.println();	
	 
  }
}
