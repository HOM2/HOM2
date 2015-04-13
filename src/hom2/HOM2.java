/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom2;

import hom2.gamelogic.NavigationController;
import hom2.gamelogic.BattleController;
import hom2.gamelogic.CharacterFactory;
import hom2.gamelogic.CharacterRepository;
import hom2.gamelogic.GameController;
import hom2.gamelogic.GameMap;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class HOM2 extends Application {

    GameController gameController;

    NavigationController navController;
    BattleController btlController;
    SceneController sceneController;
    GameMap gameMap;
    CharacterRepository characterRepo;
    CharacterFactory characterFactory;

    @Override
    public void start(Stage stage) throws Exception {
        // Application initiation

        // Load scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        this.sceneController = fxmlLoader.getController();

        stage.setScene(scene);
        stage.setResizable(false);

        // init program; connect the controllers
        this.gameController = new GameController();
        this.gameMap = new GameMap(gameController);
        this.btlController = new BattleController(gameController);
        this.characterRepo = new CharacterRepository();
        this.characterFactory = new CharacterFactory(gameController);
        this.navController = new NavigationController(gameController);

        // Pass the ref to the scene controller
        sceneController.setGameController(gameController);
        sceneController.setNavController(navController);
        sceneController.setBattleController(btlController);

        // Pass the ref to the scene controller
        sceneController.setGameController(gameController);
        sceneController.setNavController(navController);
        sceneController.setBattleController(btlController);

        gameController.setSceneController(sceneController);
        gameController.setNavController(navController);
        gameController.setBtlController(btlController);
        gameController.setCharacterRepo(characterRepo);
        gameController.setCharacterFactory(characterFactory);
        gameController.setGameMap(gameMap);

        gameController.gameInit();

        MainKeyHandler mainKeyHandler = new MainKeyHandler(navController);
        scene.setOnKeyReleased(mainKeyHandler);

        stage.show();
        sceneController.initMap();
                
    }

    // Inner class to handle Main Key inputs
    private class MainKeyHandler implements EventHandler<KeyEvent> {

        NavigationController navController;

        public MainKeyHandler(NavigationController nv) {
            super();
            this.navController = nv;
        }

        @Override
        public void handle(KeyEvent event) {
            KeyCode keyCode = event.getCode();
            GameSettings.Direction d = GameSettings.Directions.get(keyCode);

            gameController.getCmdFactoryNav().createMoveCommand(d).execute();

            event.consume();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
