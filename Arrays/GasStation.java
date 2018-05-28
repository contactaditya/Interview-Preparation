import java.util.*;
import java.io.*;

  public class GasStation {
	  
    public static int canCompleteCircuit(int[] gas, int[] cost) {  
      int gasSum = 0;
      int costSum = 0;
      int start = 0;
      int fuel = 0;
      for(int i = 0; i < gas.length; i++) {
    	gasSum += gas[i];
        costSum += cost[i];  
        fuel += gas[i] - cost[i];
        if(fuel < 0) {
          start = i + 1;
          fuel = 0;
        }
      }
      if(gasSum < costSum) {
        return -1;
      }

      return start;      
    }  

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of gas stations: ");
      int numbers = input.nextInt();   
      int gas[] = new int[numbers];
	    
      System.out.println();
      System.out.print("Please enter the amount of gas at respective stations: ");
      for (int i = 0; i < numbers; i++) {
	gas[i] = input.nextInt(); 
      }

      int cost[] = new int[numbers];
	    
      System.out.println();
      System.out.print("Please enter the cost of gas to travel from station i to its next station (i+1): ");
      for (int i = 0; i < numbers; i++) {
	cost[i] = input.nextInt(); 
      }
	   
      int result = canCompleteCircuit(gas, cost);
      System.out.println();
      if(result != -1) {
	System.out.print("The starting gas station's index if you travel around the circuit once is: " + result);
      } else {
	System.out.print("You cannot the travel around the circuit even once in the clockwise direction with the given constraints.");  
      }
    }
  }
