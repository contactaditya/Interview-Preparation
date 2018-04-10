import java.io.*;
import java.util.*;

 public class EggDropPuzzle {
	 
   public static int eggDrop(int numberofEggs, int floor) {
     /* A 2D table where entry eggFloor[i][j] will represent minimum number of trials needed for i eggs and j floors. */
     int eggFloor[][] = new int[numberofEggs+1][floor+1];
     int result = 0;
     // We need one trial for one floor and 0 trials for 0 floors.
	 
     for (int i = 1; i <= numberofEggs; i++) {
       eggFloor[i][1] = 1;
       eggFloor[i][0] = 0;
     }
	 
     // We always need j trials for one egg and j floors.
     		
     for (int j = 1; j <= floor; j++) {
       eggFloor[1][j] = j;
     }
		
     for (int i = 2; i <= numberofEggs; i++) {
       for (int j = 2; j <= floor; j++) {
         eggFloor[i][j] = Integer.MAX_VALUE;
         for (int x = 1; x <= j; x++) {
           result = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);  
           if (result < eggFloor[i][j]) {
             eggFloor[i][j] = result; 
           } 
         }
       }
     }
     return eggFloor[numberofEggs][floor];
   }	 

   public static void main(String[] args) {  
     Scanner input = new Scanner(System.in);
     System.out.print("Please enter the number of eggs: ");
     int numberofEggs = input.nextInt();  
     System.out.println();
     System.out.print("Please enter the number of floors in the building: ");
     int floor = input.nextInt();  
     int minimumTrials = eggDrop(numberofEggs, floor);	
     System.out.println();
     System.out.print("The minimum number of trials required in the worst case: " + minimumTrials);
   }
 }
