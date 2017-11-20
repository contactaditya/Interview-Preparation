import java.util.*;
import java.io.*;

  public class ShoppingOffers {
	 
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {	
       return shopping(price, special, needs);
    }	  

    private static int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
       int j = 0, result = buyWithoutSpecial(needs, price); 	
       for (List<Integer> s: special) {
         List<Integer> temp = new ArrayList<Integer>(needs);
         for (j = 0; j < needs.size(); j++) {
           int difference = temp.get(j) - s.get(j);
           if (difference < 0) {
             break;  
           }
           temp.set(j, difference);
         }
         if (j == needs.size()) {
           result = Math.min(result, s.get(j) + shopping(price, special, temp));
         }
       }
	
       return result;
    }
	
    public static int buyWithoutSpecial(List<Integer> price, List<Integer> needs) {
       int sum = 0;
       for (int i = 0; i < needs.size(); i++) {
         sum += needs.get(i) * price.get(i);
       }
       return sum;
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of items to sell: "); 
      int numberofItems = input.nextInt();   
      List<Integer> price = new ArrayList<Integer>();
	    
      System.out.println();
      System.out.print("Please enter the actual prices of the items: ");
      for (int i = 0; i < numberofItems; i++) {
	price.add(input.nextInt());
      }
	  
      System.out.println();
      System.out.print("Enter number of special offers: ");
      int numberofSpecialOffers = input.nextInt();   
	   
      List<List<Integer>> special = new ArrayList<List<Integer>>();
      for (int i = 0; i < numberofSpecialOffers; i++) {
	List<Integer> offers = new ArrayList<Integer>();  
	System.out.println(); 
	System.out.print("Please enter how many specific items you can buy using a special offer with the last number representing the price you need to pay for this offer: ");	  
	for (int j = 0; j < numberofItems+1; j++) {
          offers.add(input.nextInt());
	}
	special.add(offers);
      }
	  
      List<Integer> needs = new ArrayList<Integer>();
      System.out.println();
      System.out.print("Please enter the number which we need to buy for each item: ");
      for (int i = 0; i < numberofItems; i++) {
	needs.add(input.nextInt());
      }
	  	  
      int result = shoppingOffers(price, special, needs); 
      System.out.println();
      System.out.println("The lowest price you have to pay for exactly " + numberofItems + " items where we take optimal use of special offers is: " + result);
	
    }
  }
