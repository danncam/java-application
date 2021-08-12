package photomosaic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Photomosaic{
private BufferedImage sourceimage, outputimage, tile;
private File imagefile, tilesdirectory, outputdirectory, pixelaveragefile;
private File[] directory; 
private int[][] pixelaverage;
private int repeatingtolerance, size, range;

/**
 *
 * @author Daniel Neves Camargo 
 * Fluminense Federal University
 * 21031151
 * 18/03/2013
 */

    public Photomosaic(String[] args) throws IOException
    {
            
            imagefile = new File(args[0]);
            tilesdirectory = new File(args[1]);
            range = Integer.parseInt(args[2]);
            outputdirectory = new File(args[3]);
            repeatingtolerance = 10;
            
            loadImage();
            loadTilesFolder();
            
    }
    /* Loads the input image */
    private void loadImage() throws IOException
    {
        
            sourceimage = ImageIO.read(imagefile);
            System.out.println("Input loaded successfully");
            
            
    }
    
    /* Loads the tile's directory in a bidimensional array that contains in [0], the pixel intensity and in [1], the index of the array of files */
    private void loadTilesFolder() throws IOException
    {
        System.out.println("Loading the tile's directory...");
        pixelaveragefile = new File("PixelAverage.txt");
        directory = tilesdirectory.listFiles(new ImageDirectoryFilter());
        pixelaverage = new int[directory.length][3];
        
        
        if(!pixelaveragefile.exists() || pixelaveragefile.length() == 0)
        {
                        
                        
                        size = ImageIO.read(directory[0]).getHeight();

                        for (int i = 0; i < directory.length; i++)
                        {
                                tile = ImageIO.read(directory[i]);
                                pixelaverage[i][0] = calculateAveragePixels(tile);
                                pixelaverage[i][1] = i;



                        }
                        insertion();
                        generateCacheFile();
                        System.out.println("Files loaded successfuly");
                        
                        
        } else {
            System.out.println("Loading Pixel Average...");
                        try (FileReader reader = new FileReader(pixelaveragefile); 
                                BufferedReader breader = new BufferedReader(reader)) 
                        {
                            int i = 0, k = 0;
                            String line = breader.readLine();
                            
                            if(!tilesdirectory.getPath().equals(line))
                            {
                                    System.out.println("Please run this application again");
                                    reader.close();
                                    breader.close();
                                    pixelaveragefile.delete();
                                    System.exit(0);
                            }
                            size = Integer.parseInt(breader.readLine());
                            do
                            {
                                line = breader.readLine();
                                try {
                                    if(i == pixelaverage.length)
                                    {
                                        break;
                                    }
                                    for (; k < line.length(); k++)
                                    {
                                        if(line.charAt(k) == 't') {
                                            break;
                                        }
                                    }
                                    pixelaverage[i][0] = Integer.parseInt(line.substring(0, k));
                                    pixelaverage[i][1] = Integer.parseInt(line.substring(k + 1, line.length()));

                                    i++;
                                } catch (NumberFormatException | NullPointerException ex){
                                    System.out.println("The cache file is corrupted. Please run this application again");
                                    
                                    reader.close();
                                    breader.close();
                                    pixelaveragefile.delete();
                                    System.exit(0);
                                }
                            } while(line != null);
                        breader.close();
                        reader.close();
                        }
        
                        System.out.println("Files loaded successfuly");
            }
                /*Generating a null tile*/
            tile = new BufferedImage(size, size, BufferedImage.TYPE_BYTE_GRAY);
            File NULL00 = new File("null00.jpg");
            ImageIO.write(tile, "jpg", NULL00);
            Graphics g = tile.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, size, size);
            File NULLFF = new File("nullff.jpg");
            ImageIO.write(tile, "jpg",  NULLFF );
            
        
        
    }
    
    /* The output is the average of the RGB */
    private int calculateAveragePixels(BufferedImage img)
    {
        int red = 0, green = 0, blue = 0, grayscale = 0, pixel, length = img.getHeight() * img.getWidth();
        switch(img.getType())
        {
            case BufferedImage.TYPE_3BYTE_BGR:
                for (int i = 0; i < img.getHeight(); i++)
                {
                    for (int j = 0; j < img.getWidth(); j++)
                    {
                        pixel = img.getRGB(i, j);
                        red += (pixel >>> 16 ) & 0xff;
                        green += (pixel >>> 8 ) & 0xff;
                        blue += (pixel ) & 0xff;
                    }
                }

            red /= length;
            green /= length;
            blue /= length;
            return (int) ((red * 0.3) + (0.59 * green) + (0.11 * blue) )/3;
                
            case BufferedImage.TYPE_BYTE_GRAY:
                for (int i = 0; i < img.getHeight(); i++)
                {
                    for (int j = 0; j < img.getWidth(); j++)
                    {
                        pixel = img.getRGB(i, j);
                        grayscale += (pixel >>> 16) & 0xff;
                    }
                }
            grayscale /= length;
            return grayscale;
                
            case BufferedImage.TYPE_USHORT_GRAY:
                for (int i = 0; i < img.getHeight(); i++)
                {
                    for (int j = 0; j < img.getWidth(); j++)
                    {
                        pixel = img.getRGB(i, j);
                        grayscale += (pixel >>> 16) & 0xff;
                    }
                }
            grayscale /= length;
            return grayscale;
                
            default:
                return -1;
        }
        
    }
    

    /* Sorting files by pixel intensity */
    private void insertion()
    {
            System.out.println("Processing files...");
            for (int i = 0; i < pixelaverage.length; i++)
            {
                int pixel = pixelaverage[i][0];
                int index = pixelaverage[i][1];
                for (int j = i - 1; j >= 0 && pixelaverage[j][0] > pixel; j--)
                {
                    pixelaverage[j + 1][0] = pixelaverage[j][0];
                    pixelaverage[j + 1][1] = pixelaverage[j][1];
                    pixelaverage[j][0] = pixel;
                    pixelaverage[j][1] = index;
                }
            }
    }
    
    
    /*Organizes the directory to find the images more efficiently later*/
    private void generateCacheFile() throws IOException 
    {
        FileWriter writer = null;
        BufferedWriter bwriter = null;
        try {
            pixelaveragefile.createNewFile();
            writer = new FileWriter(pixelaveragefile);
            bwriter = new BufferedWriter(writer);
            bwriter.write(tilesdirectory.getPath());
            bwriter.newLine();
            bwriter.write(Integer.toString(size));
            bwriter.newLine();
            for (int i = 0; i < pixelaverage.length; i++)
            {
                bwriter.write(Integer.toString(pixelaverage[i][0]));
                bwriter.write('t');
                bwriter.write(Integer.toString(pixelaverage[i][1]));
                if(i == pixelaverage.length-1){
                    break;
                }
                bwriter.newLine();
            }
            bwriter.close();
            writer.close();
        } catch (IOException ex) {
            
            System.out.println("The cache file is corrupted. Please run this application again");

            writer.close();
            bwriter.close();
            pixelaveragefile.delete();
            System.exit(0);
        }
    }
    
    
    /* Generate the output mosaic file */
    public void makeMosaic() throws IOException
    {
        System.out.println("Generating Mosaic...");
        try {
            outputimage = new BufferedImage
            (sourceimage.getWidth()*size, sourceimage.getHeight()*size, BufferedImage.TYPE_BYTE_GRAY);
            
            for (int i = 0; i < sourceimage.getWidth(); i++) {
                for (int j = 0; j < sourceimage.getHeight(); j++) {
                    tile = ImageIO.read(getTile(sourceimage.getRGB(i, j) & 0xff));
                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            outputimage.setRGB(i*size + k, j*size + l,tile.getRGB(k, l));
                        }
                    }
                }
            }
            ImageIO.write(outputimage, "JPG", outputdirectory);
            
            System.out.println("Output is ready");
            
        } catch (IOException | ArrayIndexOutOfBoundsException ex) {
            ImageIO.write(outputimage, "JPG", outputdirectory);
            System.out.println("Sorry! try a new Tile Folder or other input image");
            
        }
    }
    
    
    /* Binary search to find a tile in the directory */
    private File getTile(int p) throws IOException
    {
        int start = 0, end = pixelaverage.length-1, mid, r, s;
        while(start <= end)
        {
            /* pixel range */
            r = range; s = range;
            mid = (start + end)/2;
            
            /* Avoiding a NullPointerException */
            r = mid - r < 0 ? 0 : 10;
            s = mid + s > pixelaverage.length-1 ? 0 : 10;
            
            
            if(   p >= pixelaverage[mid - r][0]  &&  p <= pixelaverage[mid + s][0]  ) 
            {
                
                
            /* Before returning, check if the tile was already used */
                
                /* Getting the first valid index of this pixel */
                while(mid-1 >= 0 && pixelaverage[mid][0] == pixelaverage[mid -1][0] && pixelaverage[mid -1][2] <= repeatingtolerance)
                {
                    mid--;
                }
                
                /* The file is ok */
                if(pixelaverage[mid][2] <= repeatingtolerance)
                {
                    pixelaverage[mid][2] = pixelaverage[mid][2] + 1;
                    return directory[pixelaverage[mid][1]];
                }  
                
                /* If the tile has been repeated several times, get the next */
                if(mid + 1 <= pixelaverage.length-1 && pixelaverage[mid][2] >= repeatingtolerance && pixelaverage[mid][0] == pixelaverage[mid + 1][0])
                {
                    mid++;
                    pixelaverage[mid][2] = pixelaverage[mid][2] + 1;
                    return directory[pixelaverage[mid][1]];

                }
                
                /* But if all valid tiles have been repeated */
                while(mid - 1 >= 0 && pixelaverage[mid][2] > repeatingtolerance && pixelaverage[mid][0] == pixelaverage[mid - 1][0])
                {
                    pixelaverage[mid][2] = 0;
                    mid--;
                    
                }
                pixelaverage[mid][2] = pixelaverage[mid][2] + 1;
                return directory[pixelaverage[mid][1]];
                
            } else {
                        if(pixelaverage[mid][0] < p)
                        {
                            start = mid +1;
                        } else {
                            end   = mid -1;
                        }
                   }
        }
                if(p >= 126){
                    return new File("nullff.jpg");
                } else {
                    return new File("null00.jpg");
                }
        
                
    
                
    }
    
    
    
}
