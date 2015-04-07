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
public class CmdSceneDisplay extends CmdScene {
    protected String msg;
    static enum MsgType{DIALOG, STATUS, POSITION}
    
    public CmdSceneDisplay(GameController gc, String msg) {
        this.gameController = gc; // Inherited
        this.msg = msg;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
