/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
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
 * game flow; also act as a mediator
 */
public class GameController {

    protected SceneController sceneController;
    protected NavigationController navController;
    protected BattleController btlController;
    protected GameMap gameMap;

    protected CharacterRepository characterRepo;
    protected CharacterFactory characterFactory;

    protected GameCharacter hero;

    protected CmdFactoryScene cmdFactoryScene;
    protected CmdFactoryNav cmdFactoryNav;
    protected CmdFactoryBtl cmdFactoryBtl;

    public GameController() {
        this.sceneController = new SceneController();
        this.btlController = new BattleController();
        this.gameMap = new GameMap();
        this.navController = new NavigationController();
        this.characterRepo = new CharacterRepository();
        this.characterFactory = new CharacterFactory(this);
        this.cmdFactoryScene = new CmdFactoryScene(this);
        this.cmdFactoryNav = new CmdFactoryNav(this);
        this.cmdFactoryBtl = new CmdFactoryBtl(this);
        
    }

    // End the game
    public void gameOver() {

    }

    // Init the game, put characters on map
    public void gameInit(){
        GameCharacter c;
        for (int i = 1; i<= GameSettings.MONSTER_NUMBER; i++){
            c = this.characterFactory.makeCharacter(GameSettings.CharacterType.GRAGON_KNIGHT);
            this.gameMap.addCharacterToRdmPosition(true, c);
        }
        buzz(this.gameMap.getOccupiedPositions().toString());
    }
    
    
    
    
    // Notification 
    public void buzz(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    public void buzz(String msg) {
        buzz("", msg);
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

    public CmdFactoryScene getCmdFactoryScene() {
        return cmdFactoryScene;
    }

    public void setCmdFactoryScene(CmdFactoryScene cmdFactoryScene) {
        this.cmdFactoryScene = cmdFactoryScene;
    }

    public CmdFactoryNav getCmdFactoryNav() {
        return cmdFactoryNav;
    }

    public void setCmdFactoryNav(CmdFactoryNav cmdFactoryNav) {
        this.cmdFactoryNav = cmdFactoryNav;
    }

    public CmdFactoryBtl getCmdFactoryBtl() {
        return cmdFactoryBtl;
    }

    public void setCmdFactoryBtl(CmdFactoryBtl cmdFactoryBtl) {
        this.cmdFactoryBtl = cmdFactoryBtl;
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

    public CmdFactoryScene getCmdSceneFactory() {
        return cmdFactoryScene;
    }

    public void setCmdSceneFactory(CmdFactoryScene cmdSceneFactory) {
        this.cmdFactoryScene = cmdSceneFactory;
    }

    public CmdFactoryNav getCmdNavFactory() {
        return cmdFactoryNav;
    }

    public void setCmdNavFactory(CmdFactoryNav cmdNavFactory) {
        this.cmdFactoryNav = cmdNavFactory;
    }

    public CmdFactoryBtl getCmdBtlFactory() {
        return cmdFactoryBtl;
    }

    public void setCmdBtlFactory(CmdFactoryBtl cmdBtlFactory) {
        this.cmdFactoryBtl = cmdBtlFactory;
    }

    public CharacterRepository getCharacterRepo() {
        return characterRepo;
    }

    public void setCharacterRepo(CharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }


}
