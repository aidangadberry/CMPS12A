//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        1/21/2014                       //
//  Program:     Program 2                       //
//  Description: A Java Program that calculates  //
//				 the number of days until X-Mas  //
//				 given an 8-digit date input	 //
//===============================================//

import java.util.*;

class XMas{
		
    public static void main(String[] args){
		XMas xmas = new XMas();
		xmas.run(args);	
	}

	//variable declarations
	String n;
	String message;
	String w_month;
	int num;
	int month;
	int day;
	int year;
	int dayOfYear;

	public void run(String[] args){
		//ask user to input a date
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter date: ");
		n = scan.next();
		num = Integer.parseInt(n);

		//calculates the day, month, and year by breaking down the input number
		day = (num/10000)%100;
		month = num/1000000;
		year = num%10000;

		
		//runs all of the programs
		execute(day,month,year);
	}
	//checks to see if the year is a leap year, returning true if it is
	public boolean isLeapYear(int year){
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	//checks to see if the date is past Xmas day
	public boolean isPastXmas(int day, int month){
		if((month==12) && (day>25)){
			message = "Invalid input.";
			w_month = "December";
			return true;
		}else{
			return false;
		}
	}

	//checks to see if it is Xmas day
	public boolean isXmas(int day, int month){
		if((month==12) && (day==25)){
			message = "Merry Christmas!";
			w_month = "December";
			return true;
		}else{
			return false;
		}
	}

	//checks to see if the date is valid, ie there are that many days in the given month
	public boolean isValidDate(int day, int month, int year){
		switch(month){
			case 1:
				if((1<=day)&&(day<=31)){
					dayOfYear = day;
					w_month = "January";
					return true;
				}else{
					return false;
				}
			case 2:
				if(isLeapYear(year)){
					if((1<=day)&&(day<=29)){
						dayOfYear = 31+day;
						w_month = "February";
						return true;
					}else{
						return false;
					}
				}else{
					if((1<=day)&&(day<=28)){
						dayOfYear = 31+day;
						w_month = "February";
						return true;
					}else{
						return false;
					}
				}
			case 3:
				if((1<=day)&&(day<=31)){
					dayOfYear = 59+day;
					w_month = "March";
					return true;
				}else{
					return false;
				}
			case 4:
				if((1<=day)&&(day<=30)){
					dayOfYear = 90+day;
					w_month = "April";
					return true;
				}else{
					return false;
				}
			case 5:
				if((1<=day)&&(day<=31)){
					dayOfYear = 120+day;
					w_month = "May";
					return true;
				}else{
					return false;
				}
			case 6:
				if((1<=day)&&(day<=30)){
					dayOfYear = 151+day;
					w_month = "June";
					return true;
				}else{
					return false;
				}
			case 7:
				if((1<=day)&&(day<=31)){
					dayOfYear = 181+day;
					w_month = "July";
					return true;
				}else{
					return false;
				}
			case 8:
				if((1<=day)&&(day<=31)){
					dayOfYear = 212+day;
					w_month = "August";
					return true;
				}else{
					return false;
				}
			case 9:
				if((1<=day)&&(day<=30)){
					dayOfYear = 243+day;
					w_month = "September";
					return true;
				}else{
					return false;
				}
			case 10:
				if((1<=day)&&(day<=31)){
					dayOfYear = 273+day;
					w_month = "October";
					return true;
				}else{
					return false;
				}
			case 11:
				if((1<=day)&&(day<=30)){
					dayOfYear = 304+day;
					w_month = "November";
					return true;
				}else{
					return false;
				}
			case 12:
				if((1<=day)&&(day<=31)){
					dayOfYear = 334+day;
					w_month = "December";
					return true;
				}else{
					return false;
				}
			default:
				return false;
		}	
	}

	//returns the number of days until Xmas
	public int daysUntilXMas(int day, int month, int year){
		if(isValidDate(day, month, year)){
			if((isLeapYear(year)) && month<3){
				return (360-dayOfYear);
			}			
		}
		return (359-dayOfYear);
	}

	//turns the date into a string stating the date
	public String constructDate(int day, String month, int year){
		return ("Date is: "+month+" "+day+", "+year);
	}

	//prints the output after running all the date checkers
	public void execute(int day, int month, int year){
		if(isXmas(day,month)){
			System.out.println(constructDate(day,w_month,year));
			System.out.println(message);
		}else{
			if(isPastXmas(day,month)){
				System.out.println(constructDate(day,w_month,year));
				System.out.println(message);
			}else{
				if(isValidDate(day,month,year)){
					System.out.println(constructDate(day,w_month,year));
					System.out.println("Days until Christmas:  " + daysUntilXMas(day,month,year));
				}else{
					System.out.println("Invalid date.");
				}
			}
		}
	}
}