package ScrapperBlaster;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPresets {
    public static void loadPreset_MainMenu(final Container mainFrame) {
        ArtAssets art = ArtAssets.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.MENU_BACKGROUND));
        
        //Set up the menu buttons
        pane.setLayout(null);
        MenuButton startGame = new MenuButton("Start Game", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton helpMenu = new MenuButton("How To Play", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton exitGame = new MenuButton("Exit Game", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        
        startGame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_ChooseDifficulty(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        helpMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_HelpMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        exitGame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        
        startGame.setBounds(225,200,189, 55);
        startGame.addText(20);
        pane.add(startGame);
        
        helpMenu.setBounds(225,275,189, 55);
        helpMenu.addText(20);
        pane.add(helpMenu);
        
        exitGame.setBounds(225,350,189, 55);
        exitGame.addText(20);
        pane.add(exitGame);
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
    public static void loadPreset_ChooseDifficulty(final Container mainFrame) {
        ArtAssets art = ArtAssets.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.MENU_BACKGROUND));
        
        //Set up the menu buttons
        pane.setLayout(null);
        MenuButton easyDifficulty = new MenuButton("Easy", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton mediumDifficulty = new MenuButton("Medium", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton hardDifficulty = new MenuButton("Hard", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton backButton = new MenuButton("Back", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        
        easyDifficulty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_Game(mainFrame, GameState.DIFFICULTY_EASY);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        mediumDifficulty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_Game(mainFrame, GameState.DIFFICULTY_MEDIUM);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        hardDifficulty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_Game(mainFrame, GameState.DIFFICULTY_HARD);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        backButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_MainMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        easyDifficulty.setBounds(225,200,189,55);
        easyDifficulty.addText(20);
        pane.add(easyDifficulty);
        
        JLabel easyDescriptionLabel = new JLabel(
            "<html><body><p style=\"font-size:10px\">Few pins.<br>Lose 100 points per miss.<br>Long pin lifetime.</p></body></html>"
        );
        easyDescriptionLabel.setBounds(50,200,220,55);
        easyDescriptionLabel.setForeground(new Color(252, 168, 90));
        pane.add(easyDescriptionLabel);
        
        mediumDifficulty.setBounds(225,275,189,55);
        mediumDifficulty.addText(20);
        pane.add(mediumDifficulty);
        
        JLabel mediumDescriptionLabel = new JLabel(
            "<html><body><p style=\"font-size:10px\">Normal number of pins.<br>Lose 200 points per miss.<br>Normal pin lifetime.</p></body></html>"
        );
        mediumDescriptionLabel.setBounds(50,275,220,55);
        mediumDescriptionLabel.setForeground(new Color(252, 168, 90));
        pane.add(mediumDescriptionLabel);
        
        hardDifficulty.setBounds(225,350,189,55);
        hardDifficulty.addText(20);
        pane.add(hardDifficulty);
        
        JLabel hardDescriptionLabel = new JLabel(
            "<html><body><p style=\"font-size:10px\">Large number of pins.<br>Lose 300 points per miss.<br>Short pin lifetime.</p></body></html>"
        );
        hardDescriptionLabel.setBounds(50,350,220,55);
        hardDescriptionLabel.setForeground(new Color(252, 168, 90));
        pane.add(hardDescriptionLabel);
        
        backButton.setBounds(500,350,100,55);
        backButton.addText(20);
        pane.add(backButton);
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
    
    public static void loadPreset_HelpMenu(final Container mainFrame) {
        ArtAssets art = ArtAssets.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.IN_GAME_BACKGROUND));
        
        //Set up the menu buttons
        pane.setLayout(null);
        MenuButton backButton = new MenuButton("Back", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton continueButton = new MenuButton("Continue", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        
        backButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_MainMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        continueButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_HelpMenu_Explanation(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        backButton.setBounds(200,400,100,55);
        backButton.addText(20);
        pane.add(backButton);
        
        continueButton.setBounds(350,400,100,55);
        continueButton.addText(20);
        pane.add(continueButton);
        
        JLabel contextLabel = new JLabel(
            "<html><body><p style=\"font-size:14px; border:1px solid #FCA85A; padding:15px\">Like any worthwhile collector's item, the world of Disney Pins has fake reproductions that try to mimic real pins. In the Pin collector world, these fake Disney Pins are called \"Scrappers.\" The name is fitting, because they're worth little more than scrap if you unknowingly buy one.<br><br>Pin collectors both big and small should be aware of these scrappers, and should take care to examine any pins before buying or trading them. If it looks odd, beware!</p></body></html>"
        );
        contextLabel.setBounds(50,50,550,240);
        contextLabel.setForeground(new Color(252, 168, 90));
        pane.add(contextLabel);
        
        JLabel contextLabel_2 = new JLabel(
            "<html><body><p style=\"font-size:14px; padding:15px\">The point of this game is to pick these scrappers out of a group of pins and blast them into oblivion!</p></body></html>"
        );
        contextLabel_2.setBounds(50,320,550,60);
        contextLabel_2.setForeground(new Color(252, 90, 90));
        pane.add(contextLabel_2);
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
    public static void loadPreset_HelpMenu_Explanation(final Container mainFrame) {
        ArtAssets art = ArtAssets.getInstance();
        PinLoader pinLoader = PinLoader.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.IN_GAME_BACKGROUND));
        
        //Set up the menu buttons
        pane.setLayout(null);
        MenuButton backButton = new MenuButton("Back", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton continueButton = new MenuButton("Continue", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        
        backButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_HelpMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        continueButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_HelpMenu_ComparePins(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        backButton.setBounds(200,400,100,55);
        backButton.addText(20);
        pane.add(backButton);
        
        continueButton.setBounds(350,400,100,55);
        continueButton.addText(20);
        pane.add(continueButton);
        
        JLabel contextLabel = new JLabel(
            "<html><body><p style=\"font-size:14px; border-bottom:1px solid #FCA85A; border-top:1px solid #FCA85A; padding-bottom:15px; padding-top:15px\">The goal is simple:<br>Look for slight discolorations, scratches, overly-bright colors, or anything else that indicates a pin is fake, and then click it!<br><br>You gain points for successfully identifying scrappers, and lose points if you guess wrong. Blast lots of scrappers in a row to get a big score multiplier.</p></body></html>"
        );
        contextLabel.setBounds(50,30,550,230);
        contextLabel.setForeground(new Color(252, 168, 90));
        pane.add(contextLabel);
        
        JLabel contextLabel_2 = new JLabel(
            "<html><body><p style=\"font-size:14px; text-align:center\">This is a pin:<br><br><br><br>Mouse over it to see what its' scrapper version looks like!</p></body></html>"
        );
        contextLabel_2.setBounds(50,250,550,150);
        contextLabel_2.setForeground(new Color(252, 90, 90));
        pane.add(contextLabel_2);
        
        ExamplePin examplePin = new ExamplePin(pinLoader.getPin(14), pinLoader.getPin(15), pane);
        examplePin.setBounds(265, 290, 70, 70);
        pane.add(examplePin);
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
    public static void loadPreset_HelpMenu_ComparePins(final Container mainFrame) {
        ArtAssets art = ArtAssets.getInstance();
        PinLoader pinLoader = PinLoader.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.IN_GAME_BACKGROUND));
        
        //Set up the menu buttons
        pane.setLayout(null);
        MenuButton backButton = new MenuButton("Back", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        MenuButton doneButton = new MenuButton("Done", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        
        backButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_HelpMenu_Explanation(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        doneButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_MainMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        backButton.setBounds(200,400,100,55);
        backButton.addText(20);
        pane.add(backButton);
        
        doneButton.setBounds(350,400,100,55);
        doneButton.addText(20);
        pane.add(doneButton);
        
        JLabel contextLabel = new JLabel(
            "<html><body><p style=\"font-size:14px\">Here are all the pins in the game. Study them carefully to spot the differences!</p></body></html>"
        );
        contextLabel.setBounds(50,0,550,120);
        contextLabel.setForeground(new Color(252, 90, 90));
        pane.add(contextLabel);
        
        ExamplePin examplePin;
        int pinNumber = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 8; x++) {
                if (pinNumber < 58) { //There are only 29 pins currently, each with one scrapper, for a total of 58. Ignore the remaining loop iterations past the 58th pin
                    examplePin = new ExamplePin(
                        pinLoader.getPin(pinNumber),
                        pinLoader.getPin(pinNumber + 1),
                        pane
                    );
                    examplePin.setBounds(
                        35 + (x * 70), //X
                        100 + (y * 70), //Y
                        70, //Width
                        70 //Height
                    );
                    pane.add(examplePin);
                }
                pinNumber = pinNumber + 2;
            }
        }
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
    
    public static void loadPreset_Game(final Container mainFrame, int difficultyLevel) {
        ArtAssets art = ArtAssets.getInstance();
        
        GamePanel gamePanel = new GamePanel(mainFrame, art.getAsset(ArtAssets.IN_GAME_BACKGROUND), difficultyLevel);
        
        mainFrame.add(gamePanel);
    }
    public static void loadPreset_GameOver(final Container mainFrame, int playerScore) {
        ArtAssets art = ArtAssets.getInstance();
        
        BackgroundPanel pane = new BackgroundPanel(art.getAsset(ArtAssets.MENU_BACKGROUND));
        pane.setLayout(null);
        
        //Set up our menu panel
        MenuButton menuButton = new MenuButton("Return To Menu", art.getAsset(ArtAssets.MENU_BUTTON_LARGE), pane);
        JLabel finalScoreLabel = new JLabel("Your Score Was: " + playerScore);
        finalScoreLabel.setForeground(new Color(252, 168, 90));
        
        menuButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mainFrame.removeAll();
                loadPreset_MainMenu(mainFrame);
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        
        finalScoreLabel.setBounds(125,200,400,55);
        finalScoreLabel.setVerticalAlignment(JLabel.CENTER);
        finalScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        finalScoreLabel.setFont(new Font("Serif", Font.BOLD, 26));
        pane.add(finalScoreLabel);
        
        menuButton.setBounds(225,350,189,55);
        menuButton.addText(20);
        pane.add(menuButton);
        
        //Add the finished panel to our main JFrame
        mainFrame.add(pane);
    }
}