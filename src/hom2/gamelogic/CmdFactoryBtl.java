/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public class CmdFactoryBtl extends CmdFactory {

    public CmdFactoryBtl(GameController gc) {
        super(gc);
    }

    @Override
    public CmdGame createCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
