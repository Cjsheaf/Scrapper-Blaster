package ScrapperBlaster;

import javax.swing.*;
import java.awt.*;

public class ComboLabel extends JLabel {
    GameState gameState;
    
    public ComboLabel() {
        gameState = GameState.getInstance();
        
        this.setText("<html><body><p style=\"font-size:18px\">Combo: x" + gameState.getMultiplier() + "</p></body></html>");
        this.setForeground(new Color(252, 90, 90));
    }
    
    public void update() {
        this.setText("<html><body><p style=\"font-size:18px\">Combo: x" + gameState.getMultiplier() + "</p></body></html>");
    }
}
