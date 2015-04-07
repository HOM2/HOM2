/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public abstract class CmdFactory {
    protected GameController gameController;
    
    public CmdFactory(GameController gc){
        this.gameController = gc;
    }
    
    public abstract CmdGame createCommand(String command);
}
