//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        2/24/2014                       //
//  Program:     Program 4	                     //
//  Description: A Java Program that prints an   //
//		 		 image of Julia set of a given   //
//		 		 function f containing real and	 //
//				 complex numbers 				 //
//===============================================//

import java.util.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

class Julia{
	public static void main(String[] args) throws IOException{

		//variable declarations
		double realC, imagC;
		double xmin, xmax, ymin, ymax;
		String fname;
		BufferedImage colorImage;
		int index = 0;

		//scan for input and set variables accordingly
		Scanner scan = new Scanner(System.in);
		System.out.println("Input: C(real) C(imag) Xmin Xmax Ymin Ymax fname");
		realC = scan.nextDouble();
		imagC = scan.nextDouble();
		xmin = scan.nextDouble();
		xmax = scan.nextDouble();
		ymin =  scan.nextDouble();
		ymax = scan.nextDouble();
		fname = scan.next();

		Complex createdComplex = new Complex(realC, imagC);
    	BufferedImage outImage = new BufferedImage(512, 512, BufferedImage.TYPE_3BYTE_BGR);

    	//loop through each pixel and call JuliaMath on it
    	for(int i=0; i<512; i++){
    		for(int j=0; j<512; j++){
    			double z_real = xmin+i*(xmax - xmin)/512.0;
    			double z_imag = ymin+j*(ymax - ymin)/512.0;

    			Complex z = new Complex(z_real, z_imag);
    			Complex c = new Complex(realC, imagC);
    			index = JuliaMath(z, c);

    			int color = getHSBColor(index);
    			outImage.setRGB(i,j,color);
    		}
    	}
		saveImage(outImage, new File(fname + ".jpg"));
	}

	//use the Julia Set formula to recursively find the index required to reach a magnitude greater than 2
	public static int JuliaMath(Complex Z, Complex C) {
		int i;

		for(i = 1; i <= 255; i++) {
			Complex temp = (Z.multiply(Z).add(C));
			if(temp.magnitude() >= 2){
				break;
			}else{
				Z = temp;
			}
		}
		return i;
	}

	//hsb color table
	public static int getHSBColor(int idx){
		return Color.getHSBColor((float)(idx/255.0), 1.0f, 1.0f).getRGB();
	}

	static BufferedImage readImage(String fname) throws Exception{

		BufferedImage image = ImageIO.read(new File(fname));
		return(image);
  	}

	//saves file
	public static void saveImage(BufferedImage img, File file) throws IOException{

		ImageWriter writer = null;
		java.util.Iterator iter = ImageIO.getImageWritersByFormatName("jpg");

		if(iter.hasNext()){
			writer = (ImageWriter)iter.next();
		}

		ImageOutputStream ios = ImageIO.createImageOutputStream(file);
		writer.setOutput(ios);

		ImageWriteParam param = new JPEGImageWriteParam(java.util.Locale.getDefault());
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
		param.setCompressionQuality(0.98f);

		writer.write(null, new IIOImage(img, null, null), param);
	}
}

//class defining methods and object creation for complex numbers
class Complex{

	//variable declaration
	double real;
	double imaginary;

	//object creation of a complex number object
	Complex(double newReal, double newImaginary){
		real = newReal;
		imaginary = newImaginary;
	}

	//finds the magnitude of a complex number in the complex coordinate plane
	public double magnitude(){
		double mag = 0;
		mag = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
		return mag;
	}

	//complex number multiplication
	public Complex multiply(Complex toMultiply){
		double realMult;
		double imagMult;
		realMult = (real*toMultiply.real-imaginary*toMultiply.imaginary);
		imagMult = (real*toMultiply.imaginary+imaginary*toMultiply.real);
		Complex multiplied = new Complex(realMult, imagMult);
		return multiplied;
	}

	//complex number addition
	public Complex add(Complex toAdd){
		double realAdd;
		double imagAdd;
		realAdd = real + toAdd.real;
		imagAdd = imaginary + toAdd.imaginary;
		Complex added = new Complex(realAdd, imagAdd);
		return added;
	}
}