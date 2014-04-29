package ScrapperBlaster;

import ScrapperBlaster.ArtAssets;

import ScrapperBlaster.ParticleSystem.ParticleManager;
import ScrapperBlaster.ParticleSystem.ParticleEffect;
import ScrapperBlaster.ParticleSystem.ExplosionEffect;
import ScrapperBlaster.ParticleSystem.ShowerEffect;
import ScrapperBlaster.ParticleSystem.SprayEffect;
import ScrapperBlaster.ParticleSystem.ViewScreen;

import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 * A wrapper class created to interface the old ParticleManager singleton with
 * the newer ParticleSystem subsystem, which does away with all singletons.
 * 
 * @author Christopher Sheaf
 */
public class ParticleManagerWrapper {
    private static ParticleManagerWrapper instance;
    
    private ParticleManager manager;
    private ViewScreen screen;
    
    private ParticleManagerWrapper() {
        manager = new ParticleManager(100);
        manager.addParticleSprite("redDot", ArtAssets.getInstance().getAsset(ArtAssets.RED_DOT));
    }
    
    public static ParticleManagerWrapper getInstance() {
        if (instance == null) {
            instance = new ParticleManagerWrapper();
        }
        return instance;
    }
    
    public static void resetInstance() {
        instance = new ParticleManagerWrapper();
    }
    
    public void attachViewScreen(ViewScreen screen) {
        this.screen = screen;
    }
    
    public void loadParticleEffects() {
        if (screen == null) {
            throw new NullPointerException("ViewScreen not loaded! Make sure to attach a ViewScreen before calling this method!");
        }
        
        ParticleEffect effect = new ExplosionEffect(2.0, 0.0, 0.98, 33, screen); //Slow, large explosion
        manager.addParticleEffect("slowExplosion", effect);
        
        effect = new ExplosionEffect(6.0, 5.0, 0.95, 4, screen); //Quick, fast explosion
        manager.addParticleEffect("fastExplosion", effect);
        
        effect = new ShowerEffect(1.0, 1.0, 0.98, 15, screen);
        manager.addParticleEffect("shower", effect);
        
        effect = new SprayEffect(0.0, 0.025 * Math.PI, 6.0, 0, screen); //Spray in standard direction with an arcwidth of PI / 80
        manager.addParticleEffect("spray", effect);
    }
    
    public void update() {
        manager.update();
    }
    
    public void drawParticles(Graphics graphics) {
        manager.drawParticles(graphics);
    }
    
    public void triggerParticleEffect(String effectName, Point2D.Double location) {
        manager.triggerParticleEffect(effectName, "redDot", location, 20);
    }
}