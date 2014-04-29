package ScrapperBlaster;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class BackgroundPanel extends JPanel {
    private BufferedImage background;
    
    public BackgroundPanel(BufferedImage new_background) {
        background = new_background;
    }
    
    public void paintComponent(Graphics graphics) {
        graphics.drawImage(background, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
        //System.out.println("Attempting to draw BackgroundPanel. The background image is: " + background.toString());
    }
}
