package ScrapperBlaster;

import java.util.Random;
import java.util.ArrayList;

//A Singleton which stores the information needed to load every pin available to the game
public class PinLoader {
    private static PinLoader instance;
    
    private ArrayList<Pin> pinDatabase;
    private Random randomGen;
    
    private PinLoader() {
        randomGen = new Random();
        pinDatabase = new ArrayList<Pin>();
        
        //Load "hollow" (no image) versions of all available pins (the pins will NOT have their images loaded until they are requested by another class)
        pinDatabase.add(new Pin("", 12825, "Regular Pin", "Sprites/Pin Images/12825.png"));
        pinDatabase.add(new Pin("", 12825, "Scrapper", "Sprites/Pin Images/12825-scrap.png"));
        pinDatabase.add(new Pin("", 16088, "Regular Pin", "Sprites/Pin Images/16088.png"));
        pinDatabase.add(new Pin("", 16088, "Scrapper", "Sprites/Pin Images/16088-scrap.png"));
        pinDatabase.add(new Pin("", 35554, "Regular Pin", "Sprites/Pin Images/35554.png"));
        pinDatabase.add(new Pin("", 35554, "Scrapper", "Sprites/Pin Images/35554-scrap.png"));
        pinDatabase.add(new Pin("", 37398, "Regular Pin", "Sprites/Pin Images/37398.png"));
        pinDatabase.add(new Pin("", 37398, "Scrapper", "Sprites/Pin Images/37398-scrap.png"));
        pinDatabase.add(new Pin("", 39032, "Regular Pin", "Sprites/Pin Images/39032.png"));
        pinDatabase.add(new Pin("", 39032, "Scrapper", "Sprites/Pin Images/39032-scrap.png"));
        pinDatabase.add(new Pin("", 51753, "Regular Pin", "Sprites/Pin Images/51753.png"));
        pinDatabase.add(new Pin("", 51753, "Scrapper", "Sprites/Pin Images/51753-scrap.png"));
        pinDatabase.add(new Pin("", 51761, "Regular Pin", "Sprites/Pin Images/51761.png"));
        pinDatabase.add(new Pin("", 51761, "Scrapper", "Sprites/Pin Images/51761-scrap.png"));
        pinDatabase.add(new Pin("", 51773, "Regular Pin", "Sprites/Pin Images/51773.png"));
        pinDatabase.add(new Pin("", 51773, "Scrapper", "Sprites/Pin Images/51773-scrap.png"));
        pinDatabase.add(new Pin("", 57294, "Regular Pin", "Sprites/Pin Images/57294.png"));
        pinDatabase.add(new Pin("", 57294, "Scrapper", "Sprites/Pin Images/57294-scrap.png"));
        pinDatabase.add(new Pin("", 58162, "Regular Pin", "Sprites/Pin Images/58162.png"));
        pinDatabase.add(new Pin("", 58162, "Scrapper", "Sprites/Pin Images/58162-scrap.png"));
        pinDatabase.add(new Pin("", 58972, "Regular Pin", "Sprites/Pin Images/58972.png"));
        pinDatabase.add(new Pin("", 58972, "Scrapper", "Sprites/Pin Images/58972-scrap.png"));
        pinDatabase.add(new Pin("", 59274, "Regular Pin", "Sprites/Pin Images/59274.png"));
        pinDatabase.add(new Pin("", 59274, "Scrapper", "Sprites/Pin Images/59274-scrap.png"));
        pinDatabase.add(new Pin("", 61203, "Regular Pin", "Sprites/Pin Images/61203.png"));
        pinDatabase.add(new Pin("", 61203, "Scrapper", "Sprites/Pin Images/61203-scrap.png"));
        pinDatabase.add(new Pin("", 62722, "Regular Pin", "Sprites/Pin Images/62722.png"));
        pinDatabase.add(new Pin("", 62722, "Scrapper", "Sprites/Pin Images/62722-scrap.png"));
        pinDatabase.add(new Pin("", 63891, "Regular Pin", "Sprites/Pin Images/63891.png"));
        pinDatabase.add(new Pin("", 63891, "Scrapper", "Sprites/Pin Images/63891-scrap.png"));
        pinDatabase.add(new Pin("", 65899, "Regular Pin", "Sprites/Pin Images/65899.png"));
        pinDatabase.add(new Pin("", 65899, "Scrapper", "Sprites/Pin Images/65899-scrap.png"));
        pinDatabase.add(new Pin("", 66607, "Regular Pin", "Sprites/Pin Images/66607.png"));
        pinDatabase.add(new Pin("", 66607, "Scrapper", "Sprites/Pin Images/66607-scrap.png"));
        pinDatabase.add(new Pin("", 66609, "Regular Pin", "Sprites/Pin Images/66609.png"));
        pinDatabase.add(new Pin("", 66609, "Scrapper", "Sprites/Pin Images/66609-scrap.png"));
        pinDatabase.add(new Pin("", 69172, "Regular Pin", "Sprites/Pin Images/69172.png"));
        pinDatabase.add(new Pin("", 69172, "Scrapper", "Sprites/Pin Images/69172-scrap.png"));
        pinDatabase.add(new Pin("", 70890, "Regular Pin", "Sprites/Pin Images/70890.png"));
        pinDatabase.add(new Pin("", 70890, "Scrapper", "Sprites/Pin Images/70890-scrap.png"));
        pinDatabase.add(new Pin("", 73704, "Regular Pin", "Sprites/Pin Images/73704.png"));
        pinDatabase.add(new Pin("", 73704, "Scrapper", "Sprites/Pin Images/73704-scrap.png"));
        pinDatabase.add(new Pin("", 75093, "Regular Pin", "Sprites/Pin Images/75093.png"));
        pinDatabase.add(new Pin("", 75093, "Scrapper", "Sprites/Pin Images/75093-scrap.png"));
        pinDatabase.add(new Pin("", 75146, "Regular Pin", "Sprites/Pin Images/75146.png"));
        pinDatabase.add(new Pin("", 75146, "Scrapper", "Sprites/Pin Images/75146-scrap.png"));
        pinDatabase.add(new Pin("", 77151, "Regular Pin", "Sprites/Pin Images/77151.png"));
        pinDatabase.add(new Pin("", 77151, "Scrapper", "Sprites/Pin Images/77151-scrap.png"));
        pinDatabase.add(new Pin("", 77196, "Regular Pin", "Sprites/Pin Images/77196.png"));
        pinDatabase.add(new Pin("", 77196, "Scrapper", "Sprites/Pin Images/77196-scrap.png"));
        pinDatabase.add(new Pin("", 77202, "Regular Pin", "Sprites/Pin Images/77202.png"));
        pinDatabase.add(new Pin("", 77202, "Scrapper", "Sprites/Pin Images/77202-scrap.png"));
        pinDatabase.add(new Pin("", 82368, "Regular Pin", "Sprites/Pin Images/82368.png"));
        pinDatabase.add(new Pin("", 82368, "Scrapper", "Sprites/Pin Images/82368-scrap.png"));
        pinDatabase.add(new Pin("", 85548, "Regular Pin", "Sprites/Pin Images/85548.png"));
        pinDatabase.add(new Pin("", 85548, "Scrapper", "Sprites/Pin Images/85548-scrap.png"));
        pinDatabase.add(new Pin("", 85643, "Regular Pin", "Sprites/Pin Images/85643.png"));
        pinDatabase.add(new Pin("", 85643, "Scrapper", "Sprites/Pin Images/85643-scrap.png"));
    }
    
    /******************************Singleton methods******************************/
    public static PinLoader getInstance() {
        if (instance == null) {
            instance = new PinLoader();
        }
        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }
    
    /******************************Pin accessor methods******************************/
    /*public static Pin getNextRandomPin() {
        int arrayLength = pinDatabase.length;
        int index;
        
        for (int x = 0; x < arrayLength; x++) {
            if (pinAccessed[x] == false) {
                break; //If there's at least one empty spot in the array, then continue.
            } else if (x == arrayLength && pinAccessed[arrayLength - 1] == true) {
                return null; //If the end of the array has been reached without an empty spot, return null early.
            }
        }
        
        do {
            index = randomGen.nextInt(arrayLength); 
        } while (pinAccessed[index] == true); //Pick the first random array location that's valid.
        
        pinAccessed[index] = true;
        pinDatabase[index].LoadImage();
        return pinDatabase[index];
    }
    public static Pin getNextInSeries(String seriesName) {
        int arrayLength = pinDatabase.length;
        int index;
        
        for (index = 0; index < arrayLength; index++) {
            if (pinAccessed[index] == false && seriesName.equals(pinDatabase[index].seriesName)) {
                pinAccessed[index] = true;
                pinDatabase[index].LoadImage();
                return pinDatabase[index]; //Return the first pin found that matches the series name which hasn't already been accessed.
            }
        }
        
        return null; //If the end of the array has been reached without any matches, return null.
    }*/
    public Pin getPin(int index) {
        pinDatabase.get(index).LoadImage();
        return Pin.getCopy(pinDatabase.get(index));
    }
    public Pin getRandomPin() {
        int index = randomGen.nextInt(pinDatabase.size());
        pinDatabase.get(index).LoadImage();
        return Pin.getCopy(pinDatabase.get(index));
    }
    public Pin getRandomPin(boolean isScrapper) {
        int arraySize = pinDatabase.size();
        int index;
        
        if (isScrapper == true) {
            do {
                index = randomGen.nextInt(arraySize); 
            } while (pinDatabase.get(index).seriesName != "Scrapper"); //Pick the first random array location that IS a scrapper.
        }
        else {
            do {
                index = randomGen.nextInt(arraySize); 
            } while (pinDatabase.get(index).seriesName == "Scrapper"); //Pick the first random array location that's NOT a scrapper.
        }
        pinDatabase.get(index).LoadImage();
        return Pin.getCopy(pinDatabase.get(index));
    }
}