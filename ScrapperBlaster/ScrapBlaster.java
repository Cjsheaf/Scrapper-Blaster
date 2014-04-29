package ScrapperBlaster;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The main class which sets up the window and loads the initial UI.
 * 
 * <br>NOTE: The commented code is used to make this game run as a Java Applet (in a web browser).
 * 
 * @author Christopher Sheaf
 */
public class ScrapBlaster /*extends JApplet*/ {
    public static void createWindow() {
        JFrame window = new JFrame("Scrapper Blaster");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        
        MenuPresets.loadPreset_MainMenu(window.getContentPane());
        
        window.pack();
        window.setVisible(true);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
    }
    
    /*public void init() {
        //This is a workaround for a security conflict with some browsers
        final JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    MenuPresets.loadPreset_MainMenu(ScrapBlaster.this.getContentPane());
                }
            });
        } catch (Exception e) {}
    }*/
    /**************************CONSTANTS**************************/
    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 500;
}