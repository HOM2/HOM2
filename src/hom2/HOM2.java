/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom2;

import hom2.gamelogic.NavigationController;
import hom2.gamelogic.BattleController;
import hom2.gamelogic.CharacterFactory;
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

    GameController gameController = new GameController();
    
    NavigationController navController = gameController.getNavController();
    BattleController btlController = gameController.getBtlController(); // TODO: no need to new when there is set below
    SceneController sceneController = gameController.getSceneController();
    GameMap gameMap = gameController.getGameMap();
    CharacterFactory characterFactory = gameController.getCharacterFactory();
     

    @Override
    public void start(Stage stage) throws Exception {
        // Application initiation

        // Load scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        this.sceneController = fxmlLoader.getController();

        stage.setScene(scene);
        stage.setResizable(false);
        
        // Pass the ref to the scene controller
        sceneController.setNavController(navController); 
        sceneController.setBattleController(btlController); 

        this.gameMap = new GameMap();
        this.gameController = new GameController();
        this.navController = new NavigationController(sceneController, gameMap, this.btlController, this.gameController);

        MainKeyHandler mainKeyHandler = new MainKeyHandler(navController);
        scene.setOnKeyPressed(mainKeyHandler);

        gameController.setSceneController(sceneController);
        gameController.setNavController(navController);
        
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
//            navController.move(keyCode);
            
            gameController.getCmdFactoryNav().createMoveCommand(keyCode).execute();
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
