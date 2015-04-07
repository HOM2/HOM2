/*
 * Copyright Yiqi Liu
 * 
 */
package hom2;

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
    public static long getMapGridsX(){
        return (long) (MAP_IMAGE.getWidth()/GRID_SIZE);
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
    public final static String DRAGON_KNIGHT_IMAGE_FILE = "/assets/monster.png";
    public final static Image HERO_IMAGE = new Image(HERO_IMAGE_FILE, false);
    public final static Image DRAGON_KNIGHT_IMAGE = new Image(DRAGON_KNIGHT_IMAGE_FILE, false);
    
    public final static double FIGURE_SCALE = 0.6; // to reduce the size of character figure and make fit in the grid easier
    
    // Character types
    public static enum CharacterType {WARRIOR, DRAGON, GRAGON_KNIGHT, DRAKE, MINION};
    
    // Monster numbers
    public final static int MONSTER_NUMBER = 10;
    
    // Animations
    public final static double CHARACTER_ANIMATION_DURATION = 500;
    
    // Controls
    // Keys
    public static enum Direction {UP, DOWN, LEFT, RIGHT};
    
    public final static Map<KeyCode, Direction> DIRECTIONS;
    static{
        DIRECTIONS = new HashMap<>();
        DIRECTIONS.put(KeyCode.UP, Direction.UP);
        DIRECTIONS.put(KeyCode.W, Direction.UP);
        DIRECTIONS.put(KeyCode.DOWN, Direction.DOWN);
        DIRECTIONS.put(KeyCode.S, Direction.DOWN);
        DIRECTIONS.put(KeyCode.LEFT, Direction.LEFT);
        DIRECTIONS.put(KeyCode.A, Direction.LEFT);
        DIRECTIONS.put(KeyCode.RIGHT, Direction.RIGHT);
        DIRECTIONS.put(KeyCode.D, Direction.RIGHT);
    }
    
    
}
