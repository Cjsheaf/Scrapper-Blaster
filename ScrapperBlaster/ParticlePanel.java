package ScrapperBlaster;

import ScrapperBlaster.ParticleSystem.ParticleManager;

import java.awt.*;
import javax.swing.*;

public class ParticlePanel extends JPanel {
    private ParticleManagerWrapper particleManager;
    private JComponent parent; //Needed to repaint the parent componenet when the image on this panel changes
    
    public ParticlePanel(JComponent parentComponent) {
        particleManager = ParticleManagerWrapper.getInstance();
        parent = parentComponent;
    }
    
    public void paintComponent(Graphics graphics) {
        particleManager.drawParticles(graphics);
        parent.repaint();
    }
}