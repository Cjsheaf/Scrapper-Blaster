package ScrapperBlaster;

import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ArtAssets {
    private static ArtAssets instance;
    
    private ArrayList<BufferedImage> assetList;
    
    private ArtAssets() {
        assetList = new ArrayList<BufferedImage>();
        loadAssets();
    }
    
    public static ArtAssets getInstance() {
        if (instance == null) {
            instance = new ArtAssets();
        }
        return instance;
    }
    
    public BufferedImage getAsset(int assetIndex) {
        return assetList.get(assetIndex);
    }
    
    private void loadAssets() {
        try {
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/IntroPageBGRed.png"))); //load MENU_BACKGROUND
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/InGamePinBookBG.png"))); //load IN_GAME_BACKGROUND
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/ButtonLrgRed.png"))); //load MENU_BUTTON_LARGE
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/TopMenuRed.png"))); //load MENU_BAR_TOP
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/TopMenuRedButton.png"))); //load MENU_BAR_BUTTON
            assetList.add(ImageIO.read(this.getClass().getClassLoader().getResource("Sprites/Particle.png"))); //load RED_DOT;
        } catch (IOException e) {
            System.out.println("ERROR: Unable to load some or all art assets");
            System.exit(2);
        }
    }
    
    public static final int MENU_BACKGROUND = 0;
    public static final int IN_GAME_BACKGROUND = 1;
    public static final int MENU_BUTTON_LARGE = 2;
    public static final int MENU_BAR_TOP = 3;
    public static final int MENU_BAR_BUTTON = 4;
    public static final int RED_DOT = 5;
}
