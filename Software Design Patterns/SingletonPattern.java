import java.util.*;

 public class SingletonPattern {
	
    private static SingletonPattern instance = null;
    private SingletonPattern() {}
    
    public static synchronized SingletonPattern getInstance() {
      if (instance == null) {
	instance = new SingletonPattern();
      }
      return instance;
    }
 
    public void getMessage() {
      System.out.println("This is an example of Singleton Pattern."); 
    }
    
    public static void main(String[] args) {
      SingletonPattern singleton = SingletonPattern.getInstance();
      singleton.getMessage();
    }
 }
