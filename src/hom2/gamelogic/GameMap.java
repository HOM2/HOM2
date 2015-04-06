/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class GameMap {

    protected long gridsX = GameSettings.MAP_GRIDS_X; // Total grids in X direction
    protected long gridsY = GameSettings.MAP_GRIDS_Y; // Total grids in Y direction
    protected Map<Point, Position> occupiedGrids; // The collection of all the occupied grids on the map

    // Constructer
    
    public GameMap() {
        this.occupiedGrids = new HashMap<>();
    }

    
    
    // Move the character in a grid to another grid
    
    public Position moveCharacter(){
        Position position = new Position();
        
    }
    
    
    
    
    public Position getGrid(Point p) {
        return this.occupiedGrids.get(p);
    }

    public Position setGrid(Point p, Position g) {
        // Validate arguments
        
        if (g == null) {
            return null;
        }

        if (p.x < 1 || p.x > this.gridsX
            || p.y < 1 || p.y > this.gridsY) {
            return null;
        }

        // set the grid
        
        Position grid;
        grid = this.occupiedGrids.get(p);
        this.occupiedGrids.put(p, g);

        return grid;
    }

    
    // Getters
    
    public long getGridsX() {
        return gridsX;
    }

    public long getGridsY() {
        return gridsY;
    }


    public Map<Point, Position> getMap() {
        return occupiedGrids;
    }

}
