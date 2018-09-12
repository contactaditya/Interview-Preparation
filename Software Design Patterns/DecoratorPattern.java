import java.io.*;
import java.util.*;

 public class DecoratorPattern {
	
   public interface Coffee {
     public double getCost(); 
     public String getIngredients(); 
   }
	
   public static class SimpleCoffee implements Coffee {
     @Override
     public double getCost() {
       return 1;
     }

     @Override
     public String getIngredients() {
       return "Coffee";
     }
   }
	
   public static abstract class CoffeeDecorator implements Coffee {
     protected final Coffee decoratedCoffee;

     public CoffeeDecorator(Coffee c) {
       this.decoratedCoffee = c;
     }

     public double getCost() { // Implementing methods of the interface
       return decoratedCoffee.getCost();
     }

     public String getIngredients() {
       return decoratedCoffee.getIngredients();
     }
   }
	
   // Decorator WithMilk mixes milk into coffee.
   static class WithMilk extends CoffeeDecorator {
     public WithMilk(Coffee c) {
       super(c);
     }

     public double getCost() { // Overriding methods defined in the abstract superclass
       return super.getCost() + 0.5;
     }

     public String getIngredients() {
       return super.getIngredients() + ", Milk";
     }
   }
	 
   // Decorator WithSprinkles mixes sprinkles onto coffee.
   static class WithSprinkles extends CoffeeDecorator {
     public WithSprinkles(Coffee c) {
       super(c);
     }

     public double getCost() {
       return super.getCost() + 0.2;
     }

     public String getIngredients() {
       return super.getIngredients() + ", Sprinkles";
     } 
   }
	
   public static void printInfo(Coffee c) {
     System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
   }

   public static void main(String[] args) {  
     Coffee c = new SimpleCoffee();
     printInfo(c);

     c = new WithMilk(c);
     printInfo(c);

     c = new WithSprinkles(c);
     printInfo(c);  
   }
 }
