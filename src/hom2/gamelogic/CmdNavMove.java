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
public class CmdNavMove extends CmdNav {
    protected GameSettings.Direction direction;
    
    public CmdNavMove(GameController gc, GameSettings.Direction d) {
        this.gameController = gc;
        this.direction = d;
    }

    @Override
    public void execute() {
        this.gameController.getNavController().move(this.direction);
    }
    
}
