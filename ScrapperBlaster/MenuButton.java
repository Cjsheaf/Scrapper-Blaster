package ScrapperBlaster;

import ScrapperBlaster.EffectSystem.FilterEffect;
import ScrapperBlaster.EffectSystem.LightenEffect;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;

public class MenuButton extends JPanel
{
    JComponent parent;
    private BufferedImage image;
    private BufferedImage highlightImage;
    private boolean isHighlighted;
    private JLabel buttonLabel;
    
    public MenuButton(String buttonText, BufferedImage new_image, JComponent parentComponent) {
        //Explicit initializations
        parent = parentComponent;
        image = FilterEffect.getCompatibleImage(new_image);
        buttonLabel = new JLabel(buttonText);
        
        //Implicit initializations
        isHighlighted = false;
        this.getHighlightedVersion();
        this.setLayout(null);
        this.addMouseListener();
    }
    
    public void paintComponent(Graphics graphics) {
        if (isHighlighted == true) {
            graphics.drawImage(highlightImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
    private void getHighlightedVersion() {
        highlightImage = FilterEffect.getImageCopy(image);
        FilterEffect highlightFilter = new LightenEffect(highlightImage, -1, 50, this);
        highlightFilter.update();
    }
    public void addMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event) {
                isHighlighted = true;
                parent.repaint();
                MenuButton.this.repaint();
            }
            public void mouseExited(MouseEvent event) {
                isHighlighted = false;
                parent.repaint();
                MenuButton.this.repaint();
            }
        });
    }
    public void addText(int textSize) {
        buttonLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        buttonLabel.setVerticalAlignment(JLabel.CENTER);
        buttonLabel.setHorizontalAlignment(JLabel.CENTER);
        buttonLabel.setFont(new Font("Serif", Font.BOLD, textSize));
        buttonLabel.setForeground(new Color(252, 168, 90));
        this.add(buttonLabel);
    }
}