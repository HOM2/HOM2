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

    protected Map<Point, Position> occupiedPositions; // The collection of all the occupied positions on the map

    protected long gridsX = GameSettings.getMapGridsX(); // Total grids in X direction
    protected long gridsY = GameSettings.getMapGridsY(); // Total grids in Y direction
    protected NavigationController navController;
    protected BattleController btlController;
    protected GameController gameController;

    // Constructer
    public GameMap() {
        this.occupiedPositions = new HashMap<>();
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
    public Position moveToNeighbour(Position p, GameSettings.Direction d) {
        if (isDirectonOutOfMap(p, d)) {
            return null;
        }

        Point newPoint = new Point(0, 0);
        if (d == GameSettings.Direction.DOWN) {
            newPoint.setLocation(p.getPoint().getX(), p.getPoint().getY() + 1);
        } else if (d == GameSettings.Direction.UP) {
            newPoint.setLocation(p.getPoint().getX(), p.getPoint().getY() - 1);
        } else if (d == GameSettings.Direction.LEFT) {
            newPoint.setLocation(p.getPoint().getX() - 1, p.getPoint().getY());
        } else if (d == GameSettings.Direction.RIGHT) {
            newPoint.setLocation(p.getPoint().getX() + 1, p.getPoint().getY());
        }

        Position newPosition = new Position();
        newPosition.setCharacter(p.getCharacter());
        newPosition.setVisible(p.isVisible());
        newPosition.setPoint(newPoint);
        this.getMap().put(newPoint, newPosition);
        
        this.getMap().remove(p.getPoint());

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

}
