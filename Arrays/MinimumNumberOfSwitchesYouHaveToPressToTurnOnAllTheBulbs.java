import java.util.*;
import java.io.*;

 public class MinimumNumberOfSwitchesYouHaveToPressToTurnOnAllTheBulbs {
   
    public static int bulbs(ArrayList<Integer> a) {
      int state = 0;
      int switches = 0;
      for (int i=0; i < a.size(); i++) {
	if(state == a.get(i)) {
	  state = 1 - state;
          switches++; 
	}
      }
      return switches;
    }	 
	 
    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of light bulbs connected by the wire: ");
      int numberOfLightBulbs = input.nextInt();
      System.out.println();
      System.out.print("Please enter the initial state of all the bulbs: ");
      ArrayList<Integer> X = new ArrayList<Integer>();
      for (int i = 0; i < numberOfLightBulbs; i++) {
	X.add(input.nextInt());
      }
      System.out.println();
      System.out.println("The minimum number of switches you have to press to turn on all the bulbs are: " + bulbs(X));
		  
      input.close();
    }
 }
