package hom2.gamelogic;

import hom2.GameSettings;
import hom2.SceneController;
import hom2.gamelogic.Characters.*;
import java.awt.Point;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Alex
 */
public class NavigationController {

    protected SceneController sceneController;
    protected GameMap gameMap;
    protected BattleController btlController;
    protected GameController game;
    protected CharacterFactory characterFactory;

    protected Position heroPosition;

    public NavigationController() {
        this.sceneController = new SceneController();
        this.gameMap = new GameMap();
        this.btlController = new BattleController();
        this.game = new GameController();
        this.characterFactory = new CharacterFactory();
    }

    public NavigationController(SceneController sc, GameMap map, BattleController bc, GameController gc) {
        this.sceneController = sc;
        this.gameMap = map;
        this.btlController = bc;
        this.game = gc;
        this.characterFactory = new CharacterFactory();

        // Init the hero's position data (in the data store)
        Point center = new Point((int) (GameSettings.getMapGridsX() - 1) / 2, (int) (GameSettings.getMapGridsY() - 1) / 2);
        Warrior hero = (Warrior) characterFactory.makeCharacter(GameSettings.CharacterType.WARRIOR);
        this.heroPosition = new Position(true, hero);
        this.heroPosition.setPoint(center);

        this.gameMap.getMap().put(center, heroPosition);
    }

    public void move(KeyCode keyCode) {
        GameSettings.Direction d = GameSettings.DIRECTIONS.get(keyCode);

        // Check with the map to see if move is possible
        // If get to the boundary, keep place and notify the user
        if (this.gameMap.isDirectonOutOfMap(heroPosition, d)) {
            this.game.buzz(heroPosition.getPoint().toString());
            
        }

        // If moving to empty space, just move the map and the scene
        Cmd_Scene_Move sceneMoveCmd
                = new Cmd_Scene_Move(this.sceneController, d);
        sceneMoveCmd.execute();

        updateCharacterPosition(heroPosition, d);
        // If encounter an enemy, initual a battle
        // Gets the battle result. If wins, move, else, game over anyway
    }

    // Move the character from a position to another position, in the data structure
    public void updateCharacterPosition(Position currentPosition, GameSettings.Direction d) {
        // is there an character in the position?
        GameCharacter currentCharacter = currentPosition.getCharacter();
        if (currentCharacter == null) {
            return;
        } else if (currentCharacter.isAlive() == false) {
            return;
        }

        // Is the moving-to position out of map?
        if (gameMap.isDirectonOutOfMap(currentPosition, d)) {
            return;
        }

        

        // Check for enemy
        Position enemy = this.gameMap.getNeighbour(currentPosition, d);
        if (enemy == null) {
            // Move the character to new position
            Position newPosition = gameMap.moveToNeighbour(currentPosition, d);
            this.heroPosition = newPosition;
            // DEBUG:
            this.game.buzz(heroPosition.getPoint().toString());

        } else { // 
            // NEXTVERSION:enemy identificaion
            // if the occupant is friendly, do nothing

            // if is enemy, fight
            BattleResult btlResult = btlController.battle(currentPosition, enemy);
            if (btlResult.isGameOver()) {
                game.gameOver();
            } else if (btlResult.isRetreat()) { //

            } else if (btlResult.isVictory()){ // Won the battle
            }else{
                
            }

        }

    }
}
