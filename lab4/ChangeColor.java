//===============================================//
//  Author:      Aidan Gadberry                  //
//  Date:        2/19/2014                       //
//  Program:     Lab 4			                 //
//  Description: A program that takes an input   //
//               image and outputs two images,   //
//               one in grayscale and one in     //
//               sepia 				             //
//===============================================//

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

public class ChangeColor{
	
  	//===================================//
  	// reads in an image                 //
  	//===================================//

  	static BufferedImage readImage(String fname) throws Exception{

		BufferedImage image = ImageIO.read(new File(fname));
		return(image);
  	}

	//===================================//
	// saves file                        //
	//===================================//

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
	
	//===================================//
	// converts color image to grayscale //
	//===================================//

	public static BufferedImage color2gray(BufferedImage inImage){

    	int width = inImage.getWidth();
    	int height = inImage.getHeight();
    	int rgb, in_r, in_g, in_b;
    	double out_r, out_g, out_b;

    	BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

	    for(int i=0; i<width; i++){
	    	for(int j=0; j<height; j++){
	    		rgb = inImage.getRGB(i,j);

	    		in_r = rgb>>16 & 0xFF;
			    in_g = rgb>>8 & 0xFF;
			    in_b = rgb & 0xFF;

			    out_r = (in_r * 0.2126 + in_g * 0.7152 + in_b * 0.0722)/256;
			    out_g = (in_r * 0.2126 + in_g * 0.7152 + in_b * 0.0722)/256;
			    out_b = (in_r * 0.2126 + in_g * 0.7152 + in_b * 0.0722)/256;

			    if(out_r>1){
			    	out_r=1.0;
			    }
			    if(out_g>1){
			    	out_g=1.0;
			    }
			    if(out_b>1){
			    	out_b=1.0;
			    }

			    Color outColor = new Color((float)out_r,(float)out_g,(float)out_b); 

			    outImage.setRGB(i,j,outColor.getRGB());
	    	}
	    }
    	return(outImage);
	}

	//===================================//
	// converts color image to sepia     //
	//===================================//
	
  	public static BufferedImage color2sepia(BufferedImage inImage){

    	int width = inImage.getWidth();
    	int height = inImage.getHeight();
    	int rgb, in_r, in_g, in_b;
    	double out_r, out_g, out_b;

    	BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

		for(int i=0; i<width; i++){
	    	for(int j=0; j<height; j++){
	    		rgb = inImage.getRGB(i,j);

	    		in_r = rgb>>16 & 0xFF;
			    in_g = rgb>>8 & 0xFF;
			    in_b = rgb & 0xFF;

			    out_r = (in_r * .393 + in_g * .769 + in_b * .189)/256;
			    out_g = (in_r * .349 + in_g * .686 + in_b * .168)/256;
			    out_b = (in_r * .272 + in_g * .534 + in_b * .131)/256;

			    if(out_r>1){
			    	out_r=1.0;
			    }
			    if(out_g>1){
			    	out_g=1.0;
			    }
			    if(out_b>1){
			    	out_b=1.0;
			    }

			    Color outColor = new Color((float)out_r,(float)out_g,(float)out_b); 

			    outImage.setRGB(i,j,outColor.getRGB());
	    	}
	    }
    	return(outImage);
	}

  	//===================================//
  	// main method here                  //
  	//===================================//

  	public static void main(String[] args) throws Exception{
    
   		BufferedImage colorImage;
   		BufferedImage grayImage;
   		BufferedImage sepiaImage;

    	if(args.length != 1){
    		System.out.println("usage is: java ChangeColor filename");
    	}else{
        	colorImage = readImage(args[0]);
			grayImage = color2gray(colorImage);
			sepiaImage = color2sepia(colorImage);

			saveImage(grayImage, new File("gray" + args[0]));
			saveImage(sepiaImage, new File("sepia" + args[0]));
        }
    }       
}
