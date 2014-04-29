package ScrapperBlaster;

import ScrapperBlaster.ParticleManagerWrapper;
import ScrapperBlaster.EffectSystem.FilterEffect;
import ScrapperBlaster.EffectSystem.FadeEffect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;
import java.awt.geom.Point2D;

public class TargetPin extends JPanel implements ActionListener {
    //Utility class references:
    private Random randomGen;
    private Timer changePinTimer; //Randomly changes the pin currently assigned to this TargetPin every time it fires
    private JComponent parent; //Needed to repaint the parent componenet when the image on this panel changes
    private FilterEffect fadeEffect;
    
    //Singleton instance references:
    private PinLoader pinLoader;
    private GameState gameState;
    private ParticleManagerWrapper particleManager;
    
    //Class-specific data:
    private Pin pin;
    private boolean isScrapper;
    
    public TargetPin(JComponent parentComponent) {
        //Get singleton instances
        pinLoader = PinLoader.getInstance();
        gameState = GameState.getInstance();
        particleManager = ParticleManagerWrapper.getInstance();
        
        //Set implicit data
        isScrapper = false;
        
        //Initialize utility classes
        AddMouseListener();
        randomGen = new Random();
        changePinTimer = new Timer(1000, this);
        this.setTimerDelay();
        changePinTimer.start();
        parent = parentComponent;
        fadeEffect = new FadeEffect(pin.image, 32, 50, this);
        fadeEffect.addActionListener(this);
    }
    public TargetPin(Pin new_pin, JComponent parentComponent) {
        //Get singleton instances
        pinLoader = PinLoader.getInstance();
        gameState = GameState.getInstance();
        particleManager = ParticleManagerWrapper.getInstance();
        
        //Set explicit data
        pin = new_pin;
        if (pin.seriesName == "Scrapper") {
            isScrapper = true;
        }
        else {
            isScrapper = false;
        }
        
        //Initialize utility classes
        this.AddMouseListener();
        randomGen = new Random();
        changePinTimer = new Timer(1000, this);
        this.setTimerDelay();
        changePinTimer.start();
        parent = parentComponent;
        fadeEffect = new FadeEffect(pin.image, 32, 50, this);
        fadeEffect.addActionListener(this);
    }
    
    public void paintComponent(Graphics graphics) {
        try {
            graphics.drawImage(pin.image, 4, 4, (this.getWidth() - 6), (this.getHeight() - 6), this);
        } catch (NullPointerException nullImage) {
            //System.out.println("ERROR: No Image Reference");
        }
        parent.repaint();
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == null) {
            fadeEffect.start();
            this.setTimerDelay();
        } else {
            switch (event.getActionCommand()) {
                case "Effect Complete":
                    changePin(pinLoader.getRandomPin());
                    this.setTimerDelay();
                    break;
            }
        }
    }
    
    public void AddMouseListener() {
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent event) {
                if (TargetPin.this.isScrapper == true) {
                    switch (gameState.getDifficultyLevel()) {
                        case GameState.DIFFICULTY_EASY:
                            gameState.addPlayerScore(100 * gameState.getMultiplier());
                            gameState.incrementMultiplier();
                            break;
                        case GameState.DIFFICULTY_MEDIUM:
                            gameState.addPlayerScore(100 * gameState.getMultiplier());
                            gameState.incrementMultiplier();
                            break;
                        case GameState.DIFFICULTY_HARD:
                            gameState.addPlayerScore(100 * gameState.getMultiplier());
                            gameState.incrementMultiplier();
                            break;
                    }
                } else {
                    switch (gameState.getDifficultyLevel()) {
                        case GameState.DIFFICULTY_EASY:
                            gameState.addPlayerScore(-100);
                            gameState.resetMultiplier();
                            break;
                        case GameState.DIFFICULTY_MEDIUM:
                            gameState.addPlayerScore(-200);
                            gameState.resetMultiplier();
                            break;
                        case GameState.DIFFICULTY_HARD:
                            gameState.addPlayerScore(-300);
                            gameState.resetMultiplier();
                            break;
                    }
                }
                //particleManager.createParticleShower(0, new Point2D.Double(TargetPin.this.getX() + event.getX(), TargetPin.this.getY() + event.getY()), 1.0, 1.0, 0.98, 15);
                particleManager.triggerParticleEffect("fastExplosion", new Point2D.Double(TargetPin.this.getX() + event.getX(), TargetPin.this.getY() + event.getY()));
                TargetPin.this.changePin(pinLoader.getRandomPin(false));
            }
        });
    }
    
    private void setTimerDelay() {
        switch (gameState.getDifficultyLevel()) {
            case GameState.DIFFICULTY_EASY:
                changePinTimer.setInitialDelay(randomGen.nextInt(10000) + 10000);
                changePinTimer.restart();
                break;
            case GameState.DIFFICULTY_MEDIUM:
                changePinTimer.setInitialDelay(randomGen.nextInt(15000) + 5000);
                changePinTimer.restart();
                break;
            case GameState.DIFFICULTY_HARD:
                changePinTimer.setInitialDelay(randomGen.nextInt(25000) + 2000);
                changePinTimer.restart();
                break;
        }
    }
    
    public void changePin(Pin new_pin) {
        pin = new_pin;
        
        if (pin != null) {
            if (pin.seriesName == "Scrapper") {
                isScrapper = true;
            } else {
                isScrapper = false;
            }
        }
        
        fadeEffect = new FadeEffect(pin.image, 32, 50, this);
        fadeEffect.addActionListener(this);
        
        this.revalidate();
        this.repaint();
        parent.repaint();
    }
}