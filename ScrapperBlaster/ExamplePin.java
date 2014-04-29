package ScrapperBlaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExamplePin extends JPanel {
    private JComponent parent; //Needed to repaint the parent componenet when the image on this panel changes
    
    //Singleton instance references:
    private PinLoader pinLoader;
    
    //Class-specific data:
    private Pin realVersion;
    private Pin scrapperVersion;
    private boolean isMouseOver;
    
    public ExamplePin(Pin new_real, Pin new_scrapper, JComponent parentComponent) {
        pinLoader = PinLoader.getInstance();
        
        this.AddMouseListener();
        parent = parentComponent;
        isMouseOver = false;
        realVersion = new_real;
        scrapperVersion = new_scrapper;
    }
    
    public void paintComponent(Graphics graphics) {
        try {
            if (isMouseOver == false) {
                graphics.drawImage(realVersion.image, 4, 4, (this.getWidth() - 6), (this.getHeight() - 6), this);
            } else {
                graphics.drawImage(scrapperVersion.image, 4, 4, (this.getWidth() - 6), (this.getHeight() - 6), this);
            }
        } catch (NullPointerException nullImage) {
            //System.out.println("ERROR: No Image Reference");
        }
        parent.repaint();
    }
    
    public void AddMouseListener() {
        this.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent event) {
                isMouseOver = true;
            }
            public void mouseExited(MouseEvent event) {
                isMouseOver = false;
            }
        });
    }
}
