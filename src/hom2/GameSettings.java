/*
 * Copyright Yiqi Liu
 * 
 */
package hom2;

import hom2.gamelogic.Characters.GameCharacter;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Alex
 */
public class GameSettings {

    // Map and Character dimensions
    public final static long GRID_SIZE = 90; // Size of the character, and map grid
    public final static long MAP_VIEW_SIZE = 700; // the viewport size (with/heigh in square) 
    public final static String MAP_FILE = "/assets/map_odd_grids.png";
    public final static Image MAP_IMAGE = new Image(MAP_FILE, false); // no background loading!!!

    // When preparing the map, we make sure the grid numbers are odd
    // so that the hero can starts in the middle of the map
    public static long getMapGridsX() {
        return (long) (MAP_IMAGE.getWidth() / GRID_SIZE);
    }

    public static long getMapGridsY() {
        return (long) (MAP_IMAGE.getHeight() / GRID_SIZE);
    }

    public static long getMapWidth() {
        return (long) (MAP_IMAGE.getWidth());
    }

    public static long getMapHeight() {
        return (long) (MAP_IMAGE.getHeight());
    }

    // Character Images
    public final static String HERO_IMAGE_FILE = "/assets/warrior.png";
    public final static String WARRIOR_IMAGE_FILE = "/assets/warrior.png";
    public final static String DRAGON_IMAGE_FILE = "/assets/dragon.png";
    public final static String DRAGON_KNIGHT_IMAGE_FILE = "/assets/dragonknight.png";
    public final static String DRAKE_IMAGE_FILE = "/assets/drake.png";

    public final static Image HERO_IMAGE = new Image(HERO_IMAGE_FILE, false);

    public final static Map<GameCharacter.CharacterType, String> CharacterImageFiles;

    static {
        CharacterImageFiles = new HashMap<>();
        CharacterImageFiles.put(GameCharacter.CharacterType.WARRIOR, WARRIOR_IMAGE_FILE);
        CharacterImageFiles.put(GameCharacter.CharacterType.DRAGON, DRAGON_IMAGE_FILE);
        CharacterImageFiles.put(GameCharacter.CharacterType.DRAGON_KNIGHT, DRAGON_KNIGHT_IMAGE_FILE);
        CharacterImageFiles.put(GameCharacter.CharacterType.DRAKES, DRAKE_IMAGE_FILE);
    }

    
    public final static Image WARRIOR_IMAGE = new Image(WARRIOR_IMAGE_FILE, false);
    public final static Image DRAGON_IMAGE = new Image(DRAGON_IMAGE_FILE, false);
    public final static Image DRAGON_KNIGHT_IMAGE = new Image(DRAGON_KNIGHT_IMAGE_FILE, false);
    public final static Image DRAKE_IMAGE = new Image(DRAKE_IMAGE_FILE, false);
    
    
    
    public final static Map<GameCharacter.CharacterType, Image> CharacterImageType;

    static {
        CharacterImageType = new HashMap<>();
        CharacterImageType.put(GameCharacter.CharacterType.WARRIOR, WARRIOR_IMAGE);
        CharacterImageType.put(GameCharacter.CharacterType.DRAGON, DRAGON_IMAGE);
        CharacterImageType.put(GameCharacter.CharacterType.DRAGON_KNIGHT, DRAGON_KNIGHT_IMAGE);
        CharacterImageType.put(GameCharacter.CharacterType.DRAKES, DRAKE_IMAGE);
    }


    public final static double FIGURE_SCALE = 0.6; // to reduce the size of character figure and make fit in the grid easier

//    // Character types
    // Removed, defined in GameCharacter class
//    public static enum CharacterType {WARRIOR, DRAGON, GRAGON_KNIGHT, DRAKE, MINION};
    
    // Monster numbers
    public final static int MONSTER_NUMBER = 15;

    // Animations
    public final static double CHARACTER_ANIMATION_DURATION = 100;

    // Controls
    // Keys
    public static enum Direction {

        UP, DOWN, LEFT, RIGHT
    };

    public final static Map<KeyCode, Direction> Directions;

    static {
        Directions = new HashMap<>();
        Directions.put(KeyCode.UP, Direction.UP);
        Directions.put(KeyCode.W, Direction.UP);
        Directions.put(KeyCode.DOWN, Direction.DOWN);
        Directions.put(KeyCode.S, Direction.DOWN);
        Directions.put(KeyCode.LEFT, Direction.LEFT);
        Directions.put(KeyCode.A, Direction.LEFT);
        Directions.put(KeyCode.RIGHT, Direction.RIGHT);
        Directions.put(KeyCode.D, Direction.RIGHT);
    }

}
