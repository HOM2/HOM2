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
    protected boolean gameOver;

    private CmdBtl heroCmd;

    public void setDefenderPosition(Position defenderPosition) {
        this.enemyPosition = defenderPosition;
    }

    protected Position heroPosition;
    protected Position enemyPosition;

    public BattleController() {
        this.battleEnded = true;
        this.gameOver = false;
    }

    public BattleController(GameController gc) {
        this.battleEnded = true;
        this.gameOver = false;
        this.gameController = gc;
        this.heroPosition = new Position();
        this.enemyPosition = new Position();
    }

    // Init a battle. The Position class holds the character
    // We need the position to decide where should the winner go after battle
    public void battle(Position heroP, Position enemyP) {
        this.battleEnded = false;
        this.heroPosition = heroP;
        this.enemyPosition = enemyP;

        // The enemy always attack first
        this.gameController.buzz("Enemy attacks...");
        attack(enemyPosition, heroPosition);
        this.gameController.getSceneController().updateStatus();
        // Prompt for action
        if (!this.isBattleEnded() && this.heroCmd != null) {
            this.gameController.buzz("Your turn!");
        } // Game over?
        else if (this.isGameOver()) {
            this.updateStatus();
            this.gameController.gameOver();
        }

    } // End battle()

    public void updateStatus() {

    }

    public void retreat(GameSettings.Direction d) {
        this.gameController.getCmdFactoryBtl().createRetreatCommand(d).execute();
    }

    public void attack(Position hero, Position enemy) {
        this.battleEnded = false;
        this.setHeroPosition(hero);
        this.setEnemyPosition(enemy);
        
        this.gameController.cmdFactoryBtl.createAttackCommand(hero, enemy).execute();
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
        return heroPosition;
    }

    public void setAttackerPosition(Position attackerPosition) {
        this.heroPosition = attackerPosition;
    }

    public Position getDefenderPosition() {
        return enemyPosition;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public CmdBtl getHeroCmd() {
        return heroCmd;
    }

    public void setHeroCmd(CmdBtl heroCmd) {
        this.heroCmd = heroCmd;
    }

    public Position getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(Position heroPosition) {
        this.heroPosition = heroPosition;
    }

    public Position getEnemyPosition() {
        return enemyPosition;
    }

    public void setEnemyPosition(Position enemyPosition) {
        this.enemyPosition = enemyPosition;
    }

}
