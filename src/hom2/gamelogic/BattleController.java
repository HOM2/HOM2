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
public class BattleController {

    protected GameController gameController;
    protected boolean battleEnded;

    protected Position attackerPosition;
    protected Position defenderPosition;

    public BattleController(){
        
    }
    
    
    public BattleController(GameController gc) {
        this.gameController = gc;
        this.battleEnded = false;
        this.attackerPosition = new Position();
        this.attackerPosition = new Position();
    }

    // Init a battle. The Position class holds the character
    // We need the position to decide where should the winner go after battle
    public void battle(Position attackerPosition, Position defenderPosition) {
        this.battleEnded = false;
        this.attackerPosition = attackerPosition;
        this.defenderPosition = defenderPosition;

        // Prompt for action
        // Receive command from SceneController
        // Calculate action for result
        // Update status of characters
    }

    ////DEBUG:
//    public void move(String direction) {
//        System.out.println(direction);
//    }
    public void retreat(GameSettings.Direction d) {
        this.gameController.getCmdFactoryBtl().createRetreatCommand(d).execute();
    }
    
    public void attack(Position attacker, Position defender){
        
    }
    
    

}
