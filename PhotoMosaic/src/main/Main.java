package main;

import java.io.IOException;
import photomosaic.Photomosaic;

/**
 *
 * @author Daniel Neves Camargo 
 * Fluminense Federal University
 * 21031151
 * 18/03/2013
 */

public class Main
{
    
	public static void main (String[] args)
	{

		try
		{
			if(args.length > 0)
			{
				if(args[0].equals("h"))
				{
					displayHelpText();
                                        System.exit(0);
				}
                                
                                Photomosaic generatedMosaic = new Photomosaic(args);
				generatedMosaic.makeMosaic();
                                
			} 
                            else {
				throw new NullPointerException();
			}
                        
                
		} catch (NullPointerException ex) {
                    System.out.println("This application requires arguments. Type ' java -jar PhotoMosaic h' for help");
                } catch (ArrayIndexOutOfBoundsException | IOException ex) {
                    System.out.println("You entered a invalid argument. Type 'java -jar photomosair.jar h' for help");
                } catch (NumberFormatException ex) {
                    System.out.println("Only the 3rd argument must be an integer.");
                }
                
	}
	
	private static void displayHelpText()
	{
        	System.out.println("\nPhotomosaic is a console application that transforms an image file in a photomosaic."
                + "\nThe application requires:"
                + "\ninput path, which can be a jpg, png or gif file;"
                + "\na folder that contains the mosaic tiles (each piece should have the same dimensions);"
                + "\na positive number that calculates the tolerance of repeating tile;"
                + "\nand finally, the output path\n"
                + "\nEnter in order"
                + "\njava -jar Photomosaic.jar input.jpg databasedirectory/ 10 output.jpg\n");
	}

}
