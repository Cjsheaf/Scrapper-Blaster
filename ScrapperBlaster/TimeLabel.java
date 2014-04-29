package ScrapperBlaster;

import javax.swing.*;
import java.awt.*;

public class TimeLabel extends JLabel {
    GameState gameState;
    
    public TimeLabel() {
        gameState = GameState.getInstance();
        
        this.setText("Time Left: " + (gameState.getTimeLeft() / 1000));
        this.setForeground(new Color(252, 168, 90));
    }
    
    public void update() {
        this.setText("Time Left: " + (gameState.getTimeLeft() / 1000));
    }
}