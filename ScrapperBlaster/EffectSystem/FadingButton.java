package ScrapperBlaster.EffectSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FadingButton extends JPanel {
    private JComponent parent;
    private BufferedImage image;
    
    private FilterEffect fadeFilter;
    
    private MediaPlayer wrongSound;
    
    public FadingButton(JComponent parentComponent) {
        //Explicit initializations
        parent = parentComponent;
        
        //Implicit initializations
        String test = "Sounds/Wrong.wav";
        Media wrong = new Media(test);
        //wrongSound = new MediaPlayer(wrong);
        
        try {
            image = ImageIO.read(new File("Sprites/ButtonLrgRed.png"));
        } catch (IOException e) {}
        
        image = FilterEffect.getCompatibleImage(image);
        
        fadeFilter = new FadeEffect(image, 32, 50, this);
        fadeFilter.addActionListener((ActionListener)parent);
        
        this.addMouseListener();
    }
    
    public void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        //wrongSound.play();
        parent.repaint();
    }
    
    public void addMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                fadeFilter.start();
            }
        });
    }
}
