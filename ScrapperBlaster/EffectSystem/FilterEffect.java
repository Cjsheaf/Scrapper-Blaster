package ScrapperBlaster.EffectSystem;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public abstract class FilterEffect implements ActionListener, ActionGenerator {
    protected BufferedImage sourceImage;
    protected BufferedImageOp[] filterArray;
    
    private JComponent parent;
    private ArrayList<ActionListener> actionListeners;
    
    private int passesLeft; //The number of times the filter will be applied until the effect is "Complete". -1 means the filter runs indefinitely or until commanded to stop
    private boolean isComplete;
    private Timer effectTimer;
    
    public FilterEffect(BufferedImage new_sourceImage, int numberOfPasses, int delayBetweenPasses, JComponent parentComponent) {
        //Set explicit data:
        sourceImage = new_sourceImage;
        passesLeft = numberOfPasses;
        parent = parentComponent;
        effectTimer = new Timer(delayBetweenPasses, this);
        
        //Set implicit data:
        actionListeners = new ArrayList<ActionListener>();
        isComplete = false;
        loadFilters();
    }
    
    public void update() {
        if (isComplete == false) {
            applyFilter();
            passesLeft--;
            if (passesLeft == 0) {
                isComplete = true;
            }
        } else {
            this.stop();
            if (parent != null) {
                this.notifyListeners(new ActionEvent(parent, ActionEvent.ACTION_PERFORMED, "Effect Complete"));
            }
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        update();
    }
    public void addActionListener(ActionListener new_listener) {
        actionListeners.add(new_listener);
    }
    public void notifyListeners(ActionEvent event) {
        for (int index = 0; index < actionListeners.size(); index++) {
            actionListeners.get(index).actionPerformed(event);
        }
    }
    
    public boolean isComplete() {
        return isComplete;
    }
    public void start() {
        effectTimer.start();
    }
    public void stop() {
        isComplete = true;
        effectTimer.stop();
    }
    
    /******************************Implemented By Inheriting Classes******************************/
    protected abstract void loadFilters();
    /**
     * Applies the filter to the target image stored in this class
     */
    protected abstract void applyFilter();
    
    /******************************Static Utility Methods******************************/
    /**
     * Hackish way of making any BufferedImage filterable by BufferedImageOp.filter()
     */
    public static BufferedImage getCompatibleImage(BufferedImage source) {
        BufferedImage compatibleImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = compatibleImage.createGraphics();
        graphics.drawImage(source, 0, 0, null);
        graphics.dispose();
        
        return compatibleImage;
    }
    public static BufferedImage getImageCopy(BufferedImage source) {
        ColorModel cm = source.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = source.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}