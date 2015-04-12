/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;


/**
 *
 * @author Alex
 */
public class CmdBtlHeal extends CmdBtl {

    public CmdBtlHeal(GameController gc) {
        super(gc);
    }

    @Override
    public void execute() {
        this.gameController.btlController.battleEnded = false;
        
        if (!this.gameController.getHero().isAlive()) {
        } else {
            this.gameController.cmdFactoryScene
                    .createDisplayCommand(CmdSceneDisplay.MsgType.DIALOG, "Healing...").execute();
            this.gameController.getHero().heal();
            this.gameController.getCmdSceneFactory()
                    .createDisplayCommand(CmdSceneDisplay.MsgType.DIALOG
                            , "HP is now " + this.gameController.getHero().healthPoints()).execute();
        }
    }

}
