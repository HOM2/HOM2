/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings.Direction;

/**
 *
 * @author Alex
 */
public class CmdSceneMove extends CmdScene {
    
    protected Direction direction;
    
    public CmdSceneMove(GameController gc, Direction d ){
        this.gameController = gc; // Inherited
        this.direction = d;
    }
    
    @Override
    public void execute(){
        if(direction == Direction.UP){
            this.gameController.getSceneController().moveUp();
        }
        else if(direction == Direction.DOWN){
            this.gameController.getSceneController().moveDown();
        }
        else if(direction == Direction.LEFT){
            this.gameController.getSceneController().moveLeft();
        }
        else if(direction == Direction.RIGHT){
            this.gameController.getSceneController().moveRight();
        }
        
        this.gameController.getSceneController().displayHeroPosition(
                this.gameController.getNavController().heroPosition.getPoint()
        );
    }
}
