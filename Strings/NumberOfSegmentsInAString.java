import java.util.*;
import java.io.*;

  public class NumberOfSegmentsInAString {
	  
	public static int countSegments(String string) {
	  int countSegments = 0;
	  for(int i=0; i < string.length(); i++) {
		if(string.charAt(i)!=' ' && (i==0 || string.charAt(i-1)==' ')) {
		   countSegments++;      
		}
	  }
	  return countSegments;
    }	  

	public static void main(String[] args) { 	 
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  int countSegments = countSegments(string);
	  System.out.println();
	  System.out.println("The number of segments in the string are: " + countSegments);
	}
  }
