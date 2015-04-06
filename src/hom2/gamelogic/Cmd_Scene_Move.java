/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings.Direction;
import hom2.SceneController;

/**
 *
 * @author Alex
 */
public class Cmd_Scene_Move extends Cmd_Scene {
    
    protected Direction direction;
    
    public Cmd_Scene_Move(SceneController nc, Direction d ){
        this.sceneController = nc; // Inherited
        this.direction = d;
    }
    
    @Override
    public void execute(){
        if(direction == Direction.UP){
            sceneController.moveUp();
        }
        else if(direction == Direction.DOWN){
            sceneController.moveDown();
        }
        else if(direction == Direction.LEFT){
            sceneController.moveLeft();
        }
        else if(direction == Direction.RIGHT){
            sceneController.moveRight();
        }        
    }
}
