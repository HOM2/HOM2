/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public class CmdScenePosition extends CmdScene {

    public static enum CmdType {

        PLACE, SHOW, HIDE
    }

    protected CmdType cmdType;
    protected Position position;

    public CmdScenePosition(GameController gc, CmdType t, Position p) {
        this.gameController = gc; // Inherited
        this.cmdType = t;
        this.position = p;
    }

    @Override
    public void execute() {
        if (this.cmdType == this.cmdType.PLACE) {
            this.gameController.getSceneController().showEnemy(position);
        }

//        if (this.cmdType == this.cmdType.SHOW) {
//            this.gameController.getSceneController().showPosition(position);
//        }
//
//        if (this.cmdType == this.cmdType.HIDE) {
//            this.gameController.getSceneController().hidePosition(position);
//        }

    }

}
