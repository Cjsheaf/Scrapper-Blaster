package ScrapperBlaster;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {
    GameState gameState;
    
    public ScoreLabel() {
        gameState = GameState.getInstance();
        
        this.setText("Your Score: " + gameState.getPlayerScore());
        this.setForeground(new Color(252, 168, 90));
    }
    
    public void update() {
        this.setText("Your Score: " + gameState.getPlayerScore());
    }
}
