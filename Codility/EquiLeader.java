import java.util.*;
import java.io.*;

  public class EquiLeader {
	  
    public static int getEquiLeader(int[] array) {
      int candidate = -1;
      int count = 0;	
      int size = 0;
      int value = array[0];
      if(array.length == 1) {
        return 0;    
      }
      
      // Find most likely candidate for the leader
          
      for(int i=0; i<array.length; i++) {
    	if(size == 0) {
    	  size++;	
    	  value = array[i];
    	} else {
    	  if(array[i] == value) {
      	    size++;
      	  }
    	  else {
    	    size--;	
    	  }
        }
      }
      
      // Verify that candidate occurs more than N/2 times
      count = 0;
      if(size>0) {
        candidate = value;     
      }
      for(int i=0; i<array.length; i++) {
    	if(array[i] == candidate) {
          count++;
        }
      }
      // If there's no leader then that there are also no equi-leaders
      if (count <= array.length/2) {
        return 0;
      }

      // There exists a leader now count the number of occurences of this leader in all sequences.
      int leader = candidate;
      int equiLeaderCount = 0;
      int leaderCount = 0;
      
      for(int i=0; i<array.length - 1; i++) {
    	if(array[i] == leader) {
          leaderCount++;
        }  
    	
    	if(leaderCount > (i+1)/2 && (count-leaderCount) > (array.length-i-1)/2) {
    	  equiLeaderCount++;
    	}
      }
     
      return equiLeaderCount;
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
        array[i] = input.nextInt();
      }     

      int numberOfEquiLeaders = getEquiLeader(array);
      System.out.println();	
      System.out.println("The number of equi leaders are: " + numberOfEquiLeaders);	
    } 
  }
