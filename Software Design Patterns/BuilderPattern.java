import java.util.*;
import java.io.*;

 public class BuilderPattern {
	 
   static class Car {
	 private int wheels;
	 private String color;

     public Car() {
	 }

	 public String getColor() {
	   return color;
	 }

	 public void setColor(final String color) {
	   this.color = color;
	 }

     public int getWheels() {
	   return wheels;
	 }

     public void setWheels(final int wheels) {
	   this.wheels = wheels;
	 }

	 @Override
	 public String toString() {
	   return "Car [wheels = " + wheels + ", color = " + color + "]";
	 }
   }
   
   static class CarBuilder {
	  private Car car;

	  public CarBuilder() {
	    car = new Car();
	  }

	  public Car build() {
	    return car;
	  }

	  public CarBuilder setColor(final String color) {
	    car.setColor(color);
	    return this;
	  }

	  public CarBuilder setWheels(final int wheels) {
	    car.setWheels(wheels);
	    return this;
	  }
   }
   
	public static void main(String[] args) {
		Car builder = new CarBuilder()
		  .setWheels(4)
          .setColor("Red")
          .build();
		
		System.out.println(builder);
	}
 } 
