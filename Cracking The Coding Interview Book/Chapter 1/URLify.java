import java.util.*;

 public class URLify {
	 
   public static void replaceSpaces(char[] string, int trueLength) {
     int spaceCount = 0, index = 0;
     for (int i = 0; i < trueLength; i++) {
       if(string[i] == ' ') {
	  spaceCount++;	
       }		  
     }
		
     index = trueLength + spaceCount * 2;
     if(trueLength < string.length) {
	string[trueLength] = '\0';
     }
	   
     for (int i = trueLength - 1; i >= 0; i--) {
       if(string[i] == ' ') {
	 string[index - 1] = '0';	 
	 string[index - 2] = '2';	 
	 string[index - 3] = '%';	 	 
	 index = index - 3;	 
       } 
       else {
	 string[index - 1] = string[i];	 
	 index--;	 
       }		 
     }
     System.out.println();
     System.out.print("The string with %20 in place of spaces is: ");    
     for(int i = 0; i < string.length; i++) {
       System.out.print(string[i]);  
     }
   }
	 
   public static void main(String[] args) { 	
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string with spaces: ");
     string = input.nextLine(); 
      
     char[] string1 = string.toCharArray();
      
     System.out.println();	
     System.out.print("Enter the true length of the string: ");
     int number = input.nextInt();  
  
     replaceSpaces(string1, number);
 
    }
  }
