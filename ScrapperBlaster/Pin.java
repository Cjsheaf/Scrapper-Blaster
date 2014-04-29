package ScrapperBlaster;

import ScrapperBlaster.EffectSystem.FilterEffect;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.net.URL;

/**
 * Storage class that describes a Disney Pin.
 * PinLoader class is responsible for creating and distributing these to other classes.
 */
public class Pin {
    public String name;
    public int pinNumber; //The actual pin SKU number on the website.
    public String seriesName;
    
    public String filePath;
    public BufferedImage image;
    
    public Pin(String new_name, int new_pinNumber, String new_seriesName, String new_filePath) {
        this.name = new_name;
        this.pinNumber = new_pinNumber;
        this.seriesName = new_seriesName;
        this.filePath = new_filePath;
    }
    public Pin(String new_name, int new_pinNumber, String new_seriesName, BufferedImage new_image) {
        this.name = new_name;
        this.pinNumber = new_pinNumber;
        this.seriesName = new_seriesName;
        image = FilterEffect.getCompatibleImage(new_image);
    }
    
    
    public void LoadImage() { //Should not be loaded until the pin is going to be displayed, in order to save space.
        if (image == null) {
            try { //Try to load the image from file
                image = ImageIO.read(this.getClass().getClassLoader().getResource(filePath));
            }
            catch (IOException e) {
                /*try { //If the image cannot be loaded from file, try to load the image from the web
                    image = ImageIO.read(new URL(this.filePath));
                }
                catch (IOException ee) {
                    System.out.println("Could not load picture for: " + this.name + " #" + this.pinNumber);
                }*/
            }
        }
    }
    
    public static Pin getCopy(Pin pinToCopy) {
        return new Pin(pinToCopy.name, pinToCopy.pinNumber, pinToCopy.seriesName, pinToCopy.image);
    }
}