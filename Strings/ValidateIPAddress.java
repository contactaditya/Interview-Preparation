import java.util.*;
import java.io.*;

  public class ValidateIPAddress {
	  
	public static String validIPAddress(String IP) { 
	  if(isValidIPv4(IP)) {
		return "IPv4";
	  }
      else if(isValidIPv6(IP)) {
    	return "IPv6";
      }
	  else {
		return "Neither";
	  }
	}

	private static boolean isValidIPv4(String IP) {
	  if(IP.length() < 7) {
		return false;
	  }
	  if(IP.charAt(0) == '.') {
		return false;
	  }
	  if(IP.charAt(IP.length() - 1) == '.') {
		return false;
	  }
	  String[] tokens = IP.split("\\.");
	  if(tokens.length != 4) {
		return false;
	  }
	  for(String token : tokens) {
		if(!isValidIPv4Token(token)) {
		  return false;
		}
	  }
	 
	  return true;
	}

	private static boolean isValidIPv4Token(String token) { 
	  if(token.startsWith("0") && token.length() > 1) {
		return false;
	  }
	  try {
		int parsedInt = Integer.parseInt(token);
		if(parsedInt < 0 || parsedInt > 255) {
		  return false;
		}
		if(parsedInt == 0 && token.charAt(0) != '0') {
		  return false;
		}
      } catch(NumberFormatException nfe) {
		return false;
	  }

	  return true;
	}

	private static boolean isValidIPv6(String IP) {
	  if(IP.length() < 15) {
		return false;	
	  }
	  if(IP.charAt(0) == ':') {
		return false;
	  }
	  if(IP.charAt(IP.length() - 1) == ':') {
		return false;
	  }
	  String[] tokens = IP.split(":");
	  if(tokens.length != 8) {
		return false;
	  }
	  for(String token : tokens) {
		if(!isValidIPv6Token(token)) {
		  return false;
		}
	  }

	  return true;
	}

	private static boolean isValidIPv6Token(String token) { 
	  if(token.length() > 4 || token.length() == 0) {
		return false;
	  }
	  char[] chars = token.toCharArray();
	  for(char c:chars) {
		boolean isDigit = c >= 48 && c <= 57;
		boolean isUppercaseAF = c >= 65 && c <= 70;
		boolean isLowerCaseAF = c >= 97 && c <= 102;
		if(!(isDigit || isUppercaseAF || isLowerCaseAF)) { 
		  return false;
		}
	  }
	 
	  return true;
	}

	public static void main(String[] args) {  
	  String IP = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  IP = input.nextLine(); 
	  String result = validIPAddress(IP);
	  System.out.println();
	  if(result == "IPv4") {
	    System.out.println("This is a valid IPv4 address.");
	  }
	  else if(result == "IPv6") {
		System.out.println("This is a valid IPv6 address.");  
	  }
	  else {
		System.out.println("This is neither a IPv4 address nor a IPv6 address.");    
	  }
	}
  }
