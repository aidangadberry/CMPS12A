//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        3/12/2014                       //
//  Program:     Program 5                       //
//  Description: A Java Class that gives you the //
//               ability to pluck and tic the    //
//               elements of an array simulating //
//               a guitar string                 //
//===============================================//

public class GString{

    //variable declaration
    CQueue gbuffer;
    double frequency;

    //constructor of a GString object
    GString(double f){
        frequency = f;
        gbuffer = new CQueue((int)((44100/f)+1));
    }

    //the "burst of white noise"
    public void pluck(){
        for(int i=0; i<gbuffer.size(); i++){
            gbuffer.buffer[i] = (float)(Math.random()-0.5);
        }
    }

    //simulate one time step using the Karplus-Strong algorithm
    public void tic(){
        gbuffer.buffer[0] = (float)(0.98*(gbuffer.buffer[0]+gbuffer.buffer[1])/2.0);
        gbuffer.shift();
    }

    //returns the first element of gbuffer array
    public double sample(){
        return gbuffer.buffer[0];
    }
}