//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        3/12/2014                       //
//  Program:     Program 5                       //
//  Description: A Java Class that gives you the //
//               ability to play notes by 	     //
//               pressing the corresponding keys //
//				 on the keyboard				 //
//===============================================//

public class Guitar{
    public static void main(String[] args) {

        // create 7 guitar strings, for notes A, B, C, D, E, and F
        double A_note = 440.000;
       	double B_note = 493.883;
        double C_note = 261.626;
        double D_note = 293.665;
        double E_note = 329.628;
        double F_note = 349.228;
        double G_note = 391.995;

        GString stringA = new GString(A_note);
        GString stringB = new GString(B_note);
        GString stringC = new GString(C_note);
        GString stringD = new GString(D_note);
        GString stringE = new GString(E_note);
        GString stringF = new GString(F_note);
        GString stringG = new GString(G_note);

        while (true) {

            // check if the user has typed a key; if so, process it   
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') { stringA.pluck(); }
                else if (key == 'b') { stringB.pluck(); }
                else if (key == 'c') { stringC.pluck(); }
                else if (key == 'd') { stringD.pluck(); }
                else if (key == 'e') { stringE.pluck(); }
                else if (key == 'f') { stringF.pluck(); }
                else if (key == 'g') { stringG.pluck(); }
            }

            // compute the superposition of samples --
            // this is what we hear if multiple notes are played
            double sample = stringA.sample() + stringB.sample() + stringC.sample() + stringD.sample()
            				 + stringE.sample() + stringF.sample() + stringG.sample();
  
            // play the sample on standard audio
            StdAudio.play(sample);
  
            // advance the simulation of each guitar string by one step   
            stringA.tic();
            stringB.tic();
            stringC.tic();
            stringD.tic();
            stringE.tic();
            stringF.tic();
            stringG.tic();
        }
    }
}