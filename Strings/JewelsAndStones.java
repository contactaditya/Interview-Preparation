import java.util.*;
import java.io.*;

  public class JewelsAndStones {
	  
	public static int numJewelsInStones(String J, String S) {  
      int result = 0;
      Set<Character> setJ = new HashSet<Character>();
      for (char j: J.toCharArray()) {
    	setJ.add(j);
      }
      for (char s: S.toCharArray()) {
    	if (setJ.contains(s)) {
    	  result++;
    	}
      }
    
      return result;      
	}	  

	public static void main(String[] args) { 	  
	  String J = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string representing the types of stones that are jewels: ");
	  J = input.nextLine();  
		  
	  System.out.println();	
	  String S = new String();	  
	  System.out.print("Enter the string representing the stones: ");
	  S = input.nextLine();  
		  
	  int numberOfJewelsInStones = numJewelsInStones(J, S);
	  System.out.println();
	  System.out.println("The number of the stones that are also jewels are: " + numberOfJewelsInStones);


	}
  }
