package hom2.gamelogic;

import hom2.GameSettings;
import hom2.SceneController;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Alex
 */
public class NavigationController {

    protected SceneController sceneController;
    protected GameMap gameMap;
    protected BattleController battleController;

    public NavigationController(SceneController sc, GameMap map, BattleController bc) {
        this.sceneController = sc;
        this.gameMap = map;
        this.battleController = bc;
    }

    public void move(KeyCode keyCode) {
        // Check with the map to see if move is possible
        
        
        // If get to the boundary, keep place and notify the user
        // If moving to empty space, just move the map and the scene
        Cmd_Scene_Move sceneMoveCmd
                = new Cmd_Scene_Move(this.sceneController, GameSettings.DIRECTIONS.get(keyCode));
        sceneMoveCmd.execute();

        // If encounter an enemy, initual a battle
        // Gets the battle result. If wins, move, else, game over anyway
    }
}
