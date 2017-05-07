import java.io.*;
import java.util.*;
 
  class Interval {
     int buy = 0;
     int sell = 0;
  }

  public class StockBuySell {
		
	// This function finds the buy sell schedule for maximum profit.
	
	public static void stockBuySell(int[] price, int numberOfStocks) {
	   if(numberOfStocks == 1) {
	      return; 
	   }
	   
	   int count = 0;
	   
	   ArrayList<Interval> solution = new ArrayList<Interval>();
	   
	   int i = 0;
	   while (i < numberOfStocks - 1) {
	 // Find Local Minima. Note that the limit is (n-2) as we are comparing present element to the next element.   
	       while ((i < numberOfStocks - 1) && (price[i + 1] <= price[i])) {
             	  i++; 
	       }
		  
	       if(i == numberOfStocks - 1) {
		  break; 
	       }
		  
	       Interval interval = new Interval();
	       interval.buy = i++;
		  
          // Find Local Maxima. Note that the limit is (n-1) as we are comparing to previous element.
	       while ((i < numberOfStocks) && (price[i] >= price[i - 1])) {
              	  i++;
	       }
		  
          // Store the index of maxima
	       interval.sell = i - 1;
	       solution.add(interval);
		  
	       count++;   
	   }
	   
	   System.out.println();
	   
	   if (count == 0) {
              System.out.println("There is no day when buying the stock " + "will make profit");
	   }
           else {
              for (int j = 0; j < count; j++) {
                 System.out.println("Buy on day: " + solution.get(j).buy + "     " + "Sell on day : " + solution.get(j).sell);
              }
           }
      return;
    }
	
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the stock price: ");
	int numberOfStocks = input.nextInt();   
	int price[] = new int[numberOfStocks];
		    
	System.out.print("\n");
	System.out.print("Please enter the actual values of the cost of the stock: ");
	for (int i = 0; i < numberOfStocks; i++) {
	   price[i] = input.nextInt(); 
	}
		 
	stockBuySell(price, numberOfStocks);
      }  
    }
