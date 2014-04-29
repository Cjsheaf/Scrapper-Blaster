package ScrapperBlaster.EffectSystem;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class DisintegrateEffect extends FilterEffect {
    public DisintegrateEffect(BufferedImage new_sourceImage, int numberOfPasses, int delayBetweenPasses, JComponent parentComponent) {
        super(new_sourceImage, numberOfPasses, delayBetweenPasses, parentComponent);
    }
    
    protected void loadFilters() {
        filterArray = new BufferedImageOp[2];
        
        // Create the different short arrays
        short[] straight = new short[256];
        short[] added = new short[256];
        short[] subtracted = new short[256];
        short[] threshold = new short[256];
        for (int i = 0; i < 256; i++) {
            //Load straight array
            straight[i] = (short)i;
            
            //Load added array
            if (i < (256 - 48)) {
                added[i] = (short)(i + 48);
            } else {
                added[i] = (short)255;
            }
            
            //Load subtracted array
            if (i > 8) {
                subtracted[i] = (short)(i - 8);
            } else {
                subtracted[i] = (short)0;
            }
            
            //Load threshold array
            if (i == 0) {
                threshold[i] = (short)255;
            } else {
                threshold[i] = (short)i;
            }
        }
        
        //Darken Image filter
        short[][] darken = new short[][] { subtracted, subtracted, subtracted, straight };
        filterArray[0] = new LookupOp(new ShortLookupTable(0, darken), null);
        
        //Change color filter (to red)
        short[][] changeToRed = new short[][] { threshold, straight, straight, straight };
        filterArray[1] = new LookupOp(new ShortLookupTable(0, changeToRed), null);
        
        //Add transparency filter (for red pixels)
        //short[][] makeRedTransparent = new short[][] { 
    }
    protected void applyFilter() {
        //Darken every pixel in the image
        filterArray[0].filter(sourceImage, sourceImage);
        
        //Pixels that are completely black turn bright red
        filterArray[1].filter(sourceImage, sourceImage);
        
        //Pixels that are bright red have their transparency added to
    }
}