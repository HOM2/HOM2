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



    public void setDefenderPosition(Position defenderPosition) {
        this.defenderPosition = defenderPosition;
    }

    protected Position attackerPosition;
    protected Position defenderPosition;

    public BattleController(){
        this.battleEnded =true;
    }
    
    
    public BattleController(GameController gc) {
        this.gameController = gc;
        this.battleEnded = true;
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
    
        public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public boolean isBattleEnded() {
        return battleEnded;
    }

    public void setBattleEnded(boolean battleEnded) {
        this.battleEnded = battleEnded;
    }

    public Position getAttackerPosition() {
        return attackerPosition;
    }

    public void setAttackerPosition(Position attackerPosition) {
        this.attackerPosition = attackerPosition;
    }

    public Position getDefenderPosition() {
        return defenderPosition;
    }
    
    

}
