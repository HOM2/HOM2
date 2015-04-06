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
    public final static Image MAP_IMAGE = new Image(MAP_FILE, true);
    public final static double MAP_WIDTH = MAP_IMAGE.getWidth();
    public final static double MAP_HEIGHT = MAP_IMAGE.getHeight();
    
    // When preparing the map, we makes sure the grid numbers are odd
    // so that the hero can starts in the middle of the map
    public final static long MAP_GRIDS_X = (long)MAP_WIDTH/GRID_SIZE; 
    public final static long MAP_GRIDS_Y = (long)MAP_HEIGHT/GRID_SIZE;
    
    // Character Images
    public final static String HERO_IMAGE_FILE = "/assets/warrior.png";
    public final static Image HERO_IMAGE = new Image(HERO_IMAGE_FILE, true);
    public final static double FIGURE_SCALE = 0.6; // to reduce the size of character figure and make fit in the grid easier
    
    
    // Animations
    public final static double CHARACTER_ANIMATION_DURATION = 500;
    
    // Controls
    // Keys
    public enum Direction {UP, DOWN, LEFT, RIGHT};
    
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
