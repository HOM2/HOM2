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
public class CmdBtlRetreat extends CmdBtl{
    protected GameSettings.Direction direction; // Direction to retreat
    
    public CmdBtlRetreat(GameController gc) {
        super(gc);
    }

    public CmdBtlRetreat(GameController gc, GameSettings.Direction d){
        super(gc);
        this.direction = d;
    }
        
    @Override
    public void execute() {
        this.gameController.btlController.battleEnded = true;
        this.gameController.cmdFactoryScene
                .createDisplayCommand(CmdSceneDisplay.MsgType.DIALOG, "Retreating...").execute();
        this.gameController.getSceneController().hideEnemy();
        this.gameController.cmdFactoryNav.createMoveCommand(this.direction).execute();
    }
    
}
