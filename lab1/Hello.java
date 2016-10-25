//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        1/6/2014                        //
//  Program:     Lab 1 assignment                //
//  Description: Add a line containing the url   //
//               to the class website, as well   //
//               as the prompting question of    //
//               "What is your name?"            //
//===============================================//

import java.util.*;

class Hello{
    public static void main( String[] args)
    {
	String  name;

	Scanner scan = new Scanner( System.in );
	System.out.println("The CMPS12A webpage is: http://users.soe.ucsc.edu/~pang/12a/w14/");
	System.out.print( "What's your name? ");
	name = scan.next();
	
	System.out.format( "Hi %s!\n", name );
    }
}
