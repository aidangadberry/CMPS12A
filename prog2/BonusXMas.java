//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        1/22/2014                       //
//  Program:     Program 2                       //
//  Description: A Java Program that calculates  //
//				 the number of days until X-Mas  //
//				 as well as the day of the week  //
//				 that X-Mas falls on			 //
//===============================================//

import java.util.*;

class BonusXMas{
		
    public static void main(String[] args){
		BonusXMas xmas = new BonusXMas();
		xmas.run(args);	
	}

	//variable declarations
	String n;
	String message;
	String w_month;
	String weekDay;
	int num;
	int month;
	int day;
	int year;
	int dayOfYear;
	int yearVal;
	int dayOfWeek;

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
		execute(day,month,year,dayOfWeek(year));
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
		if((month>12) || (month<1)){
			return false;
		}
		if(month==1){
			if((1<=day)&&(day<=31)){
				dayOfYear = day;
				w_month = "January";
				return true;
			}else{
				return false;
			}
		}
		if(month==2){
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
		}
		if(month==3){
			if((1<=day)&&(day<=31)){
				dayOfYear = 59+day;
				w_month = "March";
				return true;
			}else{
				return false;
			}
		}
		if(month==4){
			if((1<=day)&&(day<=30)){
				dayOfYear = 90+day;
				w_month = "April";
				return true;
			}else{
				return false;
			}
		}
		if(month==5){
			if((1<=day)&&(day<=31)){
				dayOfYear = 120+day;
				w_month = "May";
				return true;
			}else{
				return false;
			}
		}
		if(month==6){
			if((1<=day)&&(day<=30)){
				dayOfYear = 151+day;
				w_month = "June";
				return true;
			}else{
				return false;
			}
		}
		if(month==7){
			if((1<=day)&&(day<=31)){
				dayOfYear = 181+day;
				w_month = "July";
				return true;
			}else{
				return false;
			}
		}
		if(month==8){
			if((1<=day)&&(day<=31)){
				dayOfYear = 212+day;
				w_month = "August";
				return true;
			}else{
				return false;
			}
		}
		if(month==9){
			if((1<=day)&&(day<=30)){
				dayOfYear = 243+day;
				w_month = "September";
				return true;
			}else{
				return false;
			}
		}
		if(month==10){
			if((1<=day)&&(day<=31)){
				dayOfYear = 273+day;
				w_month = "October";
				return true;
			}else{
				return false;
			}
		}
		if(month==11){
			if((1<=day)&&(day<=30)){
				dayOfYear = 304+day;
				w_month = "November";
				return true;
			}else{
				return false;
			}
		}
		if(month==12){
			if((1<=day)&&(day<=31)){
				dayOfYear = 334+day;
				w_month = "December";
				return true;
			}else{
				return false;
			}
		}	
		return true;
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

	//returns the day of the week that XMas falls on
	public String dayOfWeek(int year){
		switch((year/100)*100){
			case 1600:
				yearVal = 0;
				break;
			case 1700:
				yearVal = 5;
				break;
			case 1800:
				yearVal = 3;
				break;
			case 1900:
				yearVal = 1;
				break;
			case 2000:
				yearVal = 0;
				break;
		}

		dayOfWeek = ((2+5*((year%100)%28)/4)+yearVal)%7;

		switch(dayOfWeek){
			case 0:
				weekDay = "Saturday";
				break;
			case 1:
				weekDay = "Sunday";
				break;
			case 2:
				weekDay = "Monday";
				break;
			case 3:
				weekDay = "Tuesday";
				break;
			case 4:
				weekDay = "Wednesday";
				break;
			case 5:
				weekDay = "Thursday";
				break;
			case 6:
				weekDay = "Friday";
				break;
		}
		return weekDay;
	}

	//prints the output after running all the date checkers
	public void execute(int day, int month, int year, String dayOfWeek){
		if(isXmas(day,month)){
			System.out.println(constructDate(day,w_month,year));
			System.out.println(message);
			System.out.println("Christmas in " + year + " falls on a " + dayOfWeek(year) + ".");
		}else{
			if(isPastXmas(day,month)){
				System.out.println(constructDate(day,w_month,year));
				System.out.println(message);
			}else{
				if(isValidDate(day,month,year)){
					System.out.println(constructDate(day,w_month,year));
					System.out.println("Days until Christmas:  " + daysUntilXMas(day,month,year));
					System.out.println("Christmas in " + year + " falls on a " + dayOfWeek(year) + ".");
				}else{
					System.out.println("Invalid date.");
				}
			}
		}
	}
}