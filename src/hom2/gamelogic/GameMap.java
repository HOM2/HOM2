/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
import hom2.Helpers;
import hom2.gamelogic.Characters.GameCharacter;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class GameMap {

    protected Map<Point, Position> occupiedPositions; // The collection of all the occupied positions on the map

    protected long gridsX = GameSettings.getMapGridsX(); // Total grids in X direction
    protected long gridsY = GameSettings.getMapGridsY(); // Total grids in Y direction
    protected GameController gameController;

    // Constructers
    public GameMap() {
        this.occupiedPositions = new HashMap<>();
    }

    public GameMap(GameController gc) {
        this.occupiedPositions = new HashMap<>();
        this.gameController = gc;
    }

    // Put a character on a position
    public Position addCharacterToRdmPosition( boolean isVisible, GameCharacter c) {
        if (c == null) {
            return null;
        }

        // Generate a random new point
        
        boolean isNewPoint = false;
        Point newPoint = new Point(0,0);

        int totalGrids = (int) (GameSettings.getMapGridsX() * GameSettings.getMapGridsY());
        
        for (int i =1; i<= totalGrids && !isNewPoint; i++) {
            int x = Helpers.randInt(1, (int) GameSettings.getMapGridsX());
            int y = Helpers.randInt(1, (int) GameSettings.getMapGridsY());
            newPoint.setLocation(x,y);
            if (!this.occupiedPositions.containsKey(newPoint)){
                isNewPoint = true;
            }
        }
        
        if (!isNewPoint){// If the map is full
            return null;
        }else{
            Position newPosition = new Position(isVisible, c);
            newPosition.setPoint(newPoint);
            this.getMap().put(newPoint, newPosition);
            return newPosition;
        }
        
    }

    // Get the neighbouring position
    public Position getNeighbour(Position p, GameSettings.Direction d) {
        if (isDirectonOutOfMap(p, d)) {
            return null;
        }

        Point newPoint = new Point(0, 0);
        Position neighbour = null;

        if (d == GameSettings.Direction.DOWN) {
            newPoint.setLocation(p.getPoint().getX(), p.getPoint().getY() + 1);
            neighbour = this.getMap().get(newPoint);
        } else if (d == GameSettings.Direction.UP) {
            newPoint.setLocation(p.getPoint().getX(), p.getPoint().getY() - 1);
            neighbour = this.getMap().get(newPoint);
        } else if (d == GameSettings.Direction.LEFT) {
            newPoint.setLocation(p.getPoint().getX() - 1, p.getPoint().getY());
            neighbour = this.getMap().get(newPoint);
        } else if (d == GameSettings.Direction.RIGHT) {
            newPoint.setLocation(p.getPoint().getX() + 1, p.getPoint().getY());
            neighbour = this.getMap().get(newPoint);
        }

        return neighbour;
    }

    // Get the neighbouring position
    public Position moveToNeighbour(Position currentPosition, GameSettings.Direction d) {
        if (isDirectonOutOfMap(currentPosition, d)) {
            return null;
        }

        Point newPoint = new Point(0, 0);
        if (d == GameSettings.Direction.DOWN) {
            newPoint.setLocation(currentPosition.getPoint().getX(), currentPosition.getPoint().getY() + 1);
        } else if (d == GameSettings.Direction.UP) {
            newPoint.setLocation(currentPosition.getPoint().getX(), currentPosition.getPoint().getY() - 1);
        } else if (d == GameSettings.Direction.LEFT) {
            newPoint.setLocation(currentPosition.getPoint().getX() - 1, currentPosition.getPoint().getY());
        } else if (d == GameSettings.Direction.RIGHT) {
            newPoint.setLocation(currentPosition.getPoint().getX() + 1, currentPosition.getPoint().getY());
        }

        Position newPosition = new Position();
        newPosition.setCharacter(currentPosition.getCharacter());
        newPosition.setVisible(currentPosition.isVisible());
        newPosition.setPoint(newPoint);
        this.getMap().put(newPoint, newPosition);

        this.getMap().remove(currentPosition.getPoint());

        return newPosition;

    }

    public boolean isDirectonOccupied(Position p, GameSettings.Direction d) {
        return (getNeighbour(p, d) != null);
    }

    public boolean isDirectonOutOfMap(Position p, GameSettings.Direction d) {
        if (d == GameSettings.Direction.DOWN) {
            return p.getPoint().y + 1 > GameSettings.getMapGridsY();
        } else if (d == GameSettings.Direction.LEFT) {
            return p.getPoint().x - 1 < 1;
        } else if (d == GameSettings.Direction.RIGHT) {
            return p.getPoint().x + 1 > GameSettings.getMapGridsX();
        } else if (d == GameSettings.Direction.UP) {
            return p.getPoint().y - 1 < 1;
        } else {
            return false;
        }
    }

    // Get the position object (which contains the character and visibility) at a coordinate
    public Position getPosition(Point p) {
        return this.occupiedPositions.get(p);
    }

    public Position setPosition(Point pnt, Position pos) {
        // Validate arguments

        if (pos == null) {
            return null;
        }

        if (pnt.x < 1 || pnt.x > this.gridsX
                || pnt.y < 1 || pnt.y > this.gridsY) {
            return null;
        }

        // set the grid
        Position grid;
        grid = this.occupiedPositions.get(pnt);
        this.occupiedPositions.put(pnt, pos);

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
        return occupiedPositions;
    }

    public Map<Point, Position> getOccupiedPositions() {
        return getMap();
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

}
