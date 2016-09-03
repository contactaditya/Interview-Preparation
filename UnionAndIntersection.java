import java.io.*;
import java.util.*;

public class UnionAndIntersection {
	
 public static void getIntersection(int[] array, int[] array1) {
	 
  System.out.println();		 
  int i = 0, j = 0;
  int x = array.length;
  int y = array1.length;
  
  ArrayList<Integer> list = new ArrayList();
  
  System.out.print("The value of interection of the sorted arrays is: ");   
  
  while(i < x && j < y) {
   if(array[i] < array1[j]) {
	 i++;  
   }
   
   else if(array[i] > array1[j]) {
     j++;  
   }
   
   else {
	list.add(array[i]);
	i++;
	j++;
   }
  }
  
 for(Integer k : list) {
   System.out.print(k + " ");
 }
 System.out.println();	 
}	
 
 public static void getUnion(int[] array, int[] array1) {
  System.out.println();		 
  int i = 0, j = 0;
  int x = array.length;
  int y = array1.length;
  
  ArrayList<Integer> list = new ArrayList();
 
  System.out.print("The value of union of the sorted arrays is: ");
  
  while(i < x && j < y) {
	if(array[i] < array1[j]) {
	  list.add(array[i]);	
	  i++;  
	}
	   
	else if(array[i] > array1[j]) {
	  list.add(array1[j]);		
	  j++;  
	}
	   
	else {
	list.add(array[i]);
	i++;
	j++;
	}
  }
  
  
  while (i < array.length) {
    list.add(array[i]);	  
    i++;
  }
  
  while (j < array1.length) {
	list.add(array1[j]);
	j++;
  }
  
  Set<Integer> uniqueSet = new TreeSet<Integer>(list);
  
  for(Integer k : uniqueSet) {
    System.out.print(k + " ");
  }
  System.out.println();	
 }
 
  public static void main(String[] args) throws NumberFormatException, IOException {
	  
  Scanner input = new Scanner(System.in);
  System.out.print("Enter number of elements in the first array: ");
  int number = input.nextInt();  
  int array[] = new int[number];
  
  System.out.println();	
  System.out.print("Please enter number: ");
  for (int i = 0; i < array.length; i++) {
    array[i] = input.nextInt();
  }
    
  Arrays.sort(array);
  
  Scanner input1 = new Scanner(System.in);
  System.out.println();	
  System.out.print("Enter number of elements in the second array: ");
  int number1 = input.nextInt();  
  int array1[] = new int[number1];
  
  System.out.println();	
  System.out.print("Please enter number: ");
  for (int i = 0; i < array1.length; i++) {
	array1[i] = input.nextInt();
  }
  
  Arrays.sort(array1);
  
  int choice = 0;
  System.out.println();	
	    
  do{	
	 System.out.println("1. To calculate the interection of the sorted arrays.");
	 System.out.println("2. To calculate the union of the sorted arrays.");
	 System.out.println("3. For exiting from the program.");
	   
	 System.out.println();	
	    	
	 System.out.print("Enter your choice: ");
	 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  
	 choice = Integer.parseInt(br1.readLine());
	 switch (choice) {
	 case 1:  getIntersection(array, array1);
	    	  break;
	 case 2:  getUnion(array, array1);
	          break;    
	 }
	 System.out.print("\n");
   }while(choice!=3);
 }     
}