/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import javafx.scene.input.KeyCode;

/**
 *
 * @author Alex
 */
public class CmdFactoryNav extends CmdFactory{

    public CmdFactoryNav(GameController gc) {
        super(gc);
    }

    @Override
    public CmdGame createCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CmdNavMove createMoveCommand(KeyCode kc){
        return new CmdNavMove(this.gameController, kc);
    }
}
