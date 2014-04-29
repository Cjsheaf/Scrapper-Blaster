package ScrapperBlaster.EffectSystem;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class LightenEffect extends FilterEffect {
    public LightenEffect(BufferedImage new_sourceImage, int numberOfPasses, int delayBetweenPasses, JComponent parentComponent) {
        super(new_sourceImage, numberOfPasses, delayBetweenPasses, parentComponent);
    }
    
    protected void loadFilters() {
        filterArray = new BufferedImageOp[1];
        
        short[] straight = new short[256];
        short[] added = new short[256];
        for (int i = 0; i < 256; i++) {
            straight[i] = (short)i;
            if (i < (256 - 16)) {
                added[i] = (short)(i + 16);
            } else {
                added[i] = 255;
            }
        }
        
        short[][] lightenColors = new short[][] { added, added, added, straight }; //Red stays the same, Green stays the same, Blue is inverted, Alpha stays the same
        filterArray[0] = new LookupOp(new ShortLookupTable(0, lightenColors), null);
    }
    protected void applyFilter() {
        filterArray[0].filter(sourceImage, sourceImage);
    }
}
