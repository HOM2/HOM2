/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;

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

    public CmdSceneMove createMoveCommand(GameSettings.Direction d) {
        return new CmdSceneMove(this.gameController, d);
    }

    public CmdSceneDisplay createDisplayCommand(CmdSceneDisplay.MsgType t, String msg){
        return new CmdSceneDisplay(this.gameController, t, msg );
    }
}
