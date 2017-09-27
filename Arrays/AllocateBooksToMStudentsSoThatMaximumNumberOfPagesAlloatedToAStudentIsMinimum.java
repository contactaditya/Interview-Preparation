import java.util.*;
import java.io.*;

  public class AllocateBooksToMStudentsSoThatMaximumNumberOfPagesAlloatedToAStudentIsMinimum {
	 
	public static int books(ArrayList<Integer> a, int b) {
	   long sum = 0;
	   
	   // return -1 if number of books is less than number of students
	   if(a.size() < b) {
		 return -1;  
	   }
	   
	   // Count total number of pages
       for (int i = 0; i < a.size(); i++) {
          sum += a.get(i);
       }
       
       // Initialize start as 0 pages and end as total pages
       int start = 0, end = (int) sum;
       int result = Integer.MAX_VALUE;
       
       // traverse until start <= end
       while (start <= end) {
         // check if it is possible to distribute books by using mid as current minimum 
    	 int mid = (start + end) / 2; 
         if (isPossible(a, b, mid)) {
            // if yes then find the minimum distribution
            result = Math.min(result, mid);	 
        	end = mid - 1; 
         }
         else {
           start = mid + 1; 
         }
       }
       
       // Return minimum number of pages
	   return result;
	}	  

	private static boolean isPossible(ArrayList<Integer> a, int b, int currentMinimum) {
	   int studentsRequired = 1;
	   int currentSum = 0;	
	   
	   // iterate over all books
       for (int i = 0; i < a.size(); i++) {
    	  if (a.get(i) > currentMinimum) {
            return false; 
    	  }
    	  
    	  if (currentSum + a.get(i) > currentMinimum) {
            studentsRequired++;
            currentSum = a.get(i);
    
            if (studentsRequired > b) {
               return false;
            }
          }
    	  else {
    		currentSum += a.get(i);  
    	  }
       }
		
	   return true;
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  ArrayList<Integer> numberOfPages = new ArrayList<>();	
		
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < number; i++) {
		numberOfPages.add(input.nextInt());
	  }
	  System.out.println();	
	  System.out.print("Enter the number of students: ");
	  int numberOfStudents = input.nextInt();  
	  
	  int result = books(numberOfPages, numberOfStudents);
	    
	  System.out.println();	
	  System.out.print("Minimum number of pages are: " + result);
	  
	}
  }
