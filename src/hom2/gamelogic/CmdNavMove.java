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
public class CmdNavMove extends CmdNav {
    protected KeyCode keycode;
    
    public CmdNavMove(GameController gc, KeyCode kc) {
        this.gameController = gc;
        this.keycode = kc;
    }

    @Override
    public void execute() {
        this.gameController.getNavController().move(this.keycode);
    }
    
}
