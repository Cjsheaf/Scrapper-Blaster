package ScrapperBlaster.EffectSystem;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class FadeEffect extends FilterEffect {
    public FadeEffect(BufferedImage new_sourceImage, int numberOfPasses, int delayBetweenPasses, JComponent parentComponent) {
        super(new_sourceImage, numberOfPasses, delayBetweenPasses, parentComponent);
    }
    
    protected void loadFilters() {
        filterArray = new BufferedImageOp[1];
        
        short[] straight = new short[256];
        short[] subtracted = new short[256];
        for (int i = 0; i < 256; i++) {
            straight[i] = (short)i;
            if (i > 8) {
                subtracted[i] = (short)(i - 8);
            } else {
                subtracted[i] = (short)0;
            }
        }
        
        //Red, Green, and Blue stay the same, while Alpha gets repeated subtracted from each time the filter is run:
        short[][] fadeAlpha = new short[][] { straight, straight, straight, subtracted };
        filterArray[0] = new LookupOp(new ShortLookupTable(0, fadeAlpha), null);
    }
    protected void applyFilter() {
        filterArray[0].filter(sourceImage, sourceImage);
    }
}