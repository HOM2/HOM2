/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Alex
 */
public class CmdFactoryScene extends CmdFactory {

    public CmdFactoryScene(GameController gc) {
        super(gc);
    }

    @Override
    public CmdGame createCommand(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CmdSceneMove createMoveCommand(KeyCode kc) {
        return new CmdSceneMove(this.gameController, GameSettings.DIRECTIONS.get(kc));
    }

}
