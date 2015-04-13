/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public abstract class CmdBtl implements CmdGame{
    protected GameController gameController;
    
    public CmdBtl(GameController gc){
        this.gameController = gc;
    }
}
