/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public class CmdSceneDisplay extends CmdScene {

    public static enum MsgType {

        DIALOG, STATUS, POSITION, BG_INFO
    }
    protected String msg;
    protected MsgType msgType;

    public CmdSceneDisplay(GameController gc, MsgType t, String msg) {
        this.gameController = gc; // Inherited
        this.msg = msg;
        this.msgType = t;
    }

    @Override
    public void execute() {
        if (this.msgType == MsgType.BG_INFO) {
            this.gameController.getSceneController().displayBgInfo(msg);
        }

        if (this.msgType == MsgType.DIALOG) {
            this.gameController.getSceneController().addDialog(msg);
        }

    }

}
