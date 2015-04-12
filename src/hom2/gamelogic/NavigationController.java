package hom2.gamelogic;

import hom2.SceneController;
import hom2.GameSettings;
import hom2.gamelogic.Characters.*;
import java.awt.Point;

/**
 *
 * @author Alex
 */
public class NavigationController {
    
    protected GameController gameController;

    protected SceneController sceneController;
    protected GameMap gameMap;
    protected BattleController btlController;
    protected CharacterFactory characterFactory;

    protected Position heroPosition;

    public NavigationController() {
//        this.sceneController = new SceneController();
//        this.gameMap = new GameMap();
//        this.btlController = new BattleController();
//        this.gameController = new GameController();
    }

    public NavigationController(GameController gc) {
        this.gameController = gc;
        this.sceneController = gc.getSceneController();
        this.gameMap = gc.getGameMap();
        this.btlController = gc.getBtlController();
        this.characterFactory = gc.getCharacterFactory();

        // Init the hero's position data (in the data store)
        Point center = new Point((int) (GameSettings.getMapGridsX() - 1) / 2 + 1, (int) (GameSettings.getMapGridsY() - 1) / 2 + 1);
        Warrior hero = (Warrior) characterFactory.makeCharacter(GameCharacter.CharacterType.WARRIOR);

        this.gameController.setHero(hero);
        
        this.heroPosition = new Position(true, hero);
        this.heroPosition.setPoint(center);

        
        this.gameMap.getMap().put(center, heroPosition);
    }

    public void move(GameSettings.Direction d) {
        
        if (d == null){
            return;
        }

        // If get to the boundary, keep place and notify the user
        if (this.gameMap.isDirectonOutOfMap(heroPosition, d)) {
            this.gameController.buzz("Your mind is free; but the world is small buddy!");
            return;
        }

        // If we've got here, we are in the boundary
        // Check if there is an enemy in the moving-to position
        Position enemy = this.gameController.getGameMap().getNeighbour(heroPosition, d);

        if (enemy == null || !enemy.getCharacter().isAlive()) {
            // If moving to empty space, just move the map and the scene
            updateCharacterPosition(heroPosition, d);
            this.gameController.cmdFactoryScene.createMoveCommand(d).execute();
        }else{
            // If encounter an enemy, initual a battle
            gameController.getSceneController().showEnemy(enemy);
            String msg = "";
            msg += "Encounter with enemy ";
            msg += enemy.getCharacter().getName();
            msg += ".";
            this.gameController.buzz(msg, "Get ready for battle!");
            this.gameController.getBtlController().setBattleEnded(false);
            
            
        }

        // Gets the battle result. If wins, move, else, game over?
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
        } else { // 
            // NEXTVERSION:enemy identificaion
            // if the occupant is friendly, do nothing

            // if is enemy, fight
            btlController.battle(currentPosition, enemy);

        }

    }
}
