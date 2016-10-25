//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        2/2/2014                        //
//  Program:     Lab 3		                     //
//  Description: A Java Program that prints a    //
//		 		 triangle pattern given triangle //
//		 		 segments per side, size of a 	 //
//				 triangle segment, and the  	 //
//				 character to be used to fill	 //
//				 the triangle segments			 //
//===============================================//


import java.util.*;

class Triangle{

	public static void main(String[] args){

		//variable declarations
		String n;
		String c;
		int side;
		int size;
		int i;
		int j;
		int k;
		int l;

		//asks the user to input values for the triangle
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter triangle values: ");
		n = scan.nextLine();

		//uses the input to set the number of triangle segments per side, size of a triangle segment, and character
		side = (int)(n.charAt(0)-'0');
		size = (int)(n.charAt(2)-'0');
		c = Character.toString(n.charAt(4));

		//prints the triangle in the console using the given side, size, and character inputs
		for(i=0; i<side; i++){
			for(j=0; j<size; j++){
				for(k=0; k<i+1; k++){
					for(l=0; l<j+1; l++){
						System.out.print(c);
					}
					for(l=l; l<size; l++){
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
		}
		System.out.println("Have a nice day. Bye.");
	}
}