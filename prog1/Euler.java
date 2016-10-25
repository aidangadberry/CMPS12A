//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        1/15/2014                       //
//  Program:     Program 1                       //
//  Description: A Java Program that calculates  //
//		 		 the asymptotic value of Euler's //
//		 		 number				 	 		 //
//===============================================//

import java.util.*;

public class Euler {
    public static void main( String[] args){
		
    	//variable declarations
    	String n;
		double a;
		double r;
		double e;
		double b;
		
		//ask user to input a number
		Scanner scan = new Scanner( System.in );
		System.out.print( "Enter n: ");
		n = scan.next();
		
		//use the inputed number to calculate the approximated Euler number value
		b = Double.parseDouble(n);
		a = Math.pow((1+1/b),b);
		r = Math.E;
		e = (Math.abs(a-r))/r*100;
		
		//print the approximated Euler value, actual Euler value, and percentage error to the console
		System.out.println( "approximated  e  = " + String.format("%.11g", a));
		System.out.println( "true value of e  = " + r);
		System.out.println( "percentage error = " + String.format("%.2f", e) + "%");
    }
}

