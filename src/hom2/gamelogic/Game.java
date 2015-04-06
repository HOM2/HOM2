/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
import static hom2.GameSettings.GRID_SIZE;
import static hom2.GameSettings.MAP_IMAGE;
import hom2.SceneController;
import hom2.gamelogic.Characters.GameCharacter;
import javafx.scene.control.Alert;

/**
 *
 * @author Alex
 */
/**
 *
 * This class is responsible for displaying the game status and controlling the
 * game flow
 */
public class Game {

    protected SceneController sceneController;
    protected NavigationController navController;
    protected BattleController btlController;
    protected GameMap gameMap;
    protected CharacterFactory characterFactory;

    protected GameCharacter hero;

    public Game() {
        this.sceneController = new SceneController();
        this.btlController = new BattleController();
        this.gameMap = new GameMap();
        this.navController = new NavigationController(sceneController, gameMap, btlController, this);
        this.characterFactory = new CharacterFactory();
    }

// End the game
    public void gameOver() {

    }

    // Getters setters
    public CharacterFactory getCharacterFactory() {
        return characterFactory;
    }

    public void setCharacterFactory(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }

    public NavigationController getNavController() {
        return navController;
    }

    public void setNavController(NavigationController navController) {
        this.navController = navController;
    }

    public BattleController getBtlController() {
        return btlController;
    }

    public void setBtlController(BattleController btlController) {
        this.btlController = btlController;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public SceneController getSceneController() {
        return sceneController;
    }

    public void setSceneController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public GameCharacter getHero() {
        return hero;
    }

    public void setHero(GameCharacter hero) {
        this.hero = hero;
    }

    public void buzz(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(msg);

        alert.showAndWait();
    }

}
