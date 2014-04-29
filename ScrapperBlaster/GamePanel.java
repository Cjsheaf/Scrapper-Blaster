package ScrapperBlaster;

import ScrapperBlaster.ParticleSystem.ParticleManager;
import ScrapperBlaster.ParticleSystem.ViewScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Random;

public class GamePanel extends BackgroundPanel implements ActionListener {
    //Utility class references:
    private Container mainJFrame; //A reference to the main JFrame. Used as an argument to switch to the Main Menu
    private Timer gameTimer;
    private Random generator = new Random();
    
    //Singleton instance references:
    private PinLoader pinLoader;
    private GameState gameState;
    private ParticleManagerWrapper particleManager;
    
    //Class-specific data:
    private TargetPin targetPin[][];
    ScoreLabel scoreLabel;
    TimeLabel timeRemainingLabel;
    ComboLabel comboLabel;
    
    public GamePanel(final Container pane, BufferedImage new_background, int difficultyLevel) {
        super(new_background);
        mainJFrame = pane;
        
        pinLoader = PinLoader.getInstance();
        gameState = GameState.getInstance();
        gameState.setDifficultyLevel(difficultyLevel);
        
        particleManager = ParticleManagerWrapper.getInstance();
        particleManager.attachViewScreen(new ViewScreen(new Rectangle(0, 0, ScrapBlaster.SCREEN_WIDTH, ScrapBlaster.SCREEN_HEIGHT)));
        particleManager.loadParticleEffects();
        
        AddComponentsToGamePanel();
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
        gameTimer = new Timer(30, this);
        gameTimer.start();
    }
    
    private void AddComponentsToGamePanel() {
        ArtAssets art = ArtAssets.getInstance();
        
        this.setLayout(null);
        
        switch (gameState.getDifficultyLevel()) {
            case GameState.DIFFICULTY_EASY:
                this.loadTargetPins(new Dimension(4, 3), 60, new Dimension(70, 70), 60, 80);
                break;
            case GameState.DIFFICULTY_MEDIUM:
                this.loadTargetPins(new Dimension(5, 4), 30, new Dimension(70, 70), 40, 70);
                break;
            case GameState.DIFFICULTY_HARD:
                this.loadTargetPins(new Dimension(7, 5), 5, new Dimension(70, 70), 60, 55);
                break;
        }
        
        
        BackgroundPanel menuBar = new BackgroundPanel(art.getAsset(ArtAssets.MENU_BAR_TOP));
        menuBar.setBounds(0, 0, 640, 28);
        this.add(menuBar);
        this.setComponentZOrder(menuBar, 5);
        
        scoreLabel = new ScoreLabel();
        scoreLabel.setBounds(100, 0, 175, 28);
        this.add(scoreLabel);
        this.setComponentZOrder(scoreLabel, 5);
        
        timeRemainingLabel = new TimeLabel();
        timeRemainingLabel.setBounds(250, 0, 100, 28);
        this.add(timeRemainingLabel);
        this.setComponentZOrder(timeRemainingLabel, 5);
        
        MenuButton menuButton = new MenuButton("Main Menu", art.getAsset(ArtAssets.MENU_BAR_BUTTON), this);
        menuButton.setBounds(0, 0, 79, 28);
        menuButton.addText(12);
        menuButton.addMouseListener(new MouseAdapter() { //In case of click:
            public void mouseClicked(MouseEvent e) { //Remove everything and load the Main Menu
                gameTimer.stop();
                GameState.resetInstance();
                ParticleManagerWrapper.resetInstance();
                
                mainJFrame.removeAll();
                MenuPresets.loadPreset_MainMenu(mainJFrame);
                mainJFrame.validate();
                mainJFrame.repaint();
            }
        });
        this.add(menuButton);
        this.setComponentZOrder(menuButton, 6);
        
        comboLabel = new ComboLabel();
        comboLabel.setBounds(10, 420, 150, 50);
        this.add(comboLabel);
        this.setComponentZOrder(comboLabel, 6);
        
        ParticlePanel particlePanel = new ParticlePanel(this);
        particlePanel.setBounds(0, 0, ScrapBlaster.SCREEN_WIDTH, ScrapBlaster.SCREEN_HEIGHT);
        particlePanel.setOpaque(false);
        this.add(particlePanel);
        this.setComponentZOrder(particlePanel, 7);
    }
    private void loadTargetPins(Dimension arrayDimensions, int pinInset, Dimension pinDimensions, int verticalMargin, int horizontalMargin) {
        targetPin = new TargetPin[arrayDimensions.width][arrayDimensions.height];
        
        for (int x = 0; x < arrayDimensions.width; x++) {
            for (int y = 0; y < arrayDimensions.height; y++) {
                targetPin[x][y] = new TargetPin(pinLoader.getRandomPin(), this);
                targetPin[x][y].setBounds(((pinDimensions.width + pinInset) * x) + horizontalMargin, ((pinDimensions.height + pinInset) * y) + verticalMargin, pinDimensions.width, pinDimensions.height);
                this.add(targetPin[x][y]);
            }
        }
    }
    
    
    public void actionPerformed(ActionEvent e) {
        gameState.update();
        scoreLabel.update();
        comboLabel.update();
        timeRemainingLabel.update();
        particleManager.update();
        
        if (gameState.isGameOver() == true) {
            mainJFrame.removeAll();
            MenuPresets.loadPreset_GameOver(mainJFrame, gameState.getPlayerScore());
            mainJFrame.validate();
            mainJFrame.repaint();
            
            gameTimer.stop();
            GameState.resetInstance();
            ParticleManagerWrapper.resetInstance();
        }
        
        this.repaint();
    }
}