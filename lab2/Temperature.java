//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        1/22/2014                       //
//  Program:     Lab 2 assignment                //
//  Description: Given a correct input of a      //
//				 temperature in Kelvin, Celcius, //
//				 or Fahrenheit, this program     //
// 				 will output the converted       //
//				 values in the other two scales	 //
//===============================================//

import java.util.*;

class Temperature{
	public static void main(String[] args) {

        //variable declarations
    	Scanner scan;
    	String scale;
    	String str;
    	double val;
    	double c;
    	double f;
    	double k;
        char s;
        int numLength = 0;

        //scans for an input
    	System.out.print("Enter temperature: ");
    	scan = new Scanner(System.in);
        str = scan.nextLine();

        //grabs the numerical part of the string
        for(int i=0; i<str.length(); i++){
            if((int)str.charAt(i)>44 && (int)str.charAt(i)<58){
                numLength++;
            }else{
                break;
            }
        }

        //if there is no numerical part, it exits the program
        if(numLength==0){
            System.out.println(str + " is an unknown temperature scale.");
            System.out.println("Goodbye.");
            System.exit(0);
        }

        //sets val as a double of the numerical part of the string, and sets scale to the rest of the string
        val = Double.parseDouble(str.substring(0,numLength));
        scale = str.substring(numLength+1,str.length());

    	//checks to see if scale is any of the valid inputs (C, c, K, k, F, f)
        if(scale.length()==1){
            s = scale.charAt(0);
        	if((int)s==99 || (int)s==67){

        		//calculate the values of the other scales
        		c = val;
        		f = c*(9.0/5)+32;
        		k = c+273.15;

        		//prints the message of the values in all the scales
        		System.out.println(String.format("%.2f", c) + " Centigrade = " + String.format("%.2f", f) +
                                   " Fahrenheit = " + String.format("%.2f", k) + " Kelvin");
                System.out.println("Have a nice day.  Goodbye");
        	}else{
        		if((int)s==107 || (int)s==75){

        			//calculate the values of the other scales
        			k = val;
        			c = k-273.15;
        			f = c*(9.0/5)+32;

        			//prints the message of the values in all the scales
        			System.out.println(String.format("%.2f", c) + " Centigrade = " + String.format("%.2f", f) +
                                       " Fahrenheit = " + String.format("%.2f", k) + " Kelvin");
                    System.out.println("Have a nice day.  Goodbye");
        		}else{
        			if((int)s==102 || (int)s==70){

        				//calculate the values of the other scales
        				f = val;
        				c = (f-32)*(5.0/9);
        				k = c+273.15;

        				//prints the message of the values in all the scales
        				System.out.println(String.format("%.2f", c) + " Centigrade = " + String.format("%.2f", f) +
                                           " Fahrenheit = " + String.format("%.2f", k) + " Kelvin");
        				System.out.println("Have a nice day.  Goodbye");
        			}else{

        				//if it is not a valid scale input, then print error message
        				System.out.println(scale + " is an unknown temperature scale.");
        				System.out.println("Goodbye.");
        			}
        		}
        	}
        }else{

            //if scale is more than a single letter, it will produce an error
            System.out.println(scale + " is an unknown temperature scale.");
            System.out.println("Goodbye.");
        }
	}
}
