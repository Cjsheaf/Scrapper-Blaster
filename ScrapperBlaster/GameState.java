package ScrapperBlaster;


public class GameState { //A singleton that stores the current game state
    private static GameState instance = null;
    
    private int difficultyLevel;
    private int playerScore;
    private int timeLeft;
    private int scoreMultiplier;
    private boolean isGameOver;

    private GameState() {
        difficultyLevel = 1;
        playerScore = 0;
        timeLeft = 60000;
        scoreMultiplier = 1;
        isGameOver = false;
    }
    
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    public static void resetInstance() {
        instance = new GameState();
    }
    
    /******************************Per-Frame Methods******************************/
    public void update() {
        timeLeft -= 30;
        
        if (timeLeft <= 0) {
            isGameOver = true;
        }
    }
    
    /******************************Score Methods******************************/
    public int getPlayerScore() {
        return playerScore;
    }
    public void addPlayerScore(int scoreToAdd) { //Negative values subtract score!
        //The player's score cannot go below 0
        if (playerScore + scoreToAdd >= 0) {
            playerScore += scoreToAdd;
        } else {
            playerScore = 0;
        }
    }
    public int getMultiplier() {
        return scoreMultiplier;
    }
    public void incrementMultiplier() {
        scoreMultiplier++;
    }
    public void resetMultiplier() {
        scoreMultiplier = 1;
    }
    
    /******************************Other Setter Methods******************************/
    public void setDifficultyLevel(int new_difficultyLevel) {
        difficultyLevel = new_difficultyLevel;
    }
    
    /******************************Other Getter Methods******************************/
    public int getTimeLeft() {
        return timeLeft;
    }
    public boolean isGameOver() {
        return isGameOver;
    }
    public int getDifficultyLevel() {
        return difficultyLevel;   
    }
    
    /******************************Constants******************************/
    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_MEDIUM = 2;
    public static final int DIFFICULTY_HARD = 3;
}