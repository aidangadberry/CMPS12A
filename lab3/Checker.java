//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        2/2/2014                        //
//  Program:     Lab 3		                     //
//  Description: A Java Program that prints a    //
//		 		 checkerboard pattern given row, //
//		 		 column, cell size, and the 	 //
//				 character to be used to fill 	 //
//				 the alternating cells			 //
//===============================================//


import java.util.*;

class Checker{

	public static void main(String[] args){

		//variable declarations
		String n;
		String c;
		int row;
		int col;
		int size;
		int i;
		int j;
		int k;
		int l;

		//asks the user to input values for the checkerboard
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter checkerboard values: ");
		n = scan.nextLine();

		//uses the input to set the row, col, size, and character
		row = (int)(n.charAt(0)-'0');
		col = (int)(n.charAt(2)-'0');
		size = (int)(n.charAt(4)-'0');
		c = Character.toString(n.charAt(6));

		//prints the checkerboard in the console using the given row, col, size, and character inputs
		for(i=0; i<row; i++){
			for(k=0; k<size; k++){
				for(j=0; j<col; j++){
					for(l=0; l<size; l++){
						if((i + j)%2 == 0){
							System.out.print(c);
						}else{
							System.out.print(" ");
						}
					}
				}
				System.out.println("");
			}
		}
		System.out.println("Have a nice day.  Goodbye.");
	}
}