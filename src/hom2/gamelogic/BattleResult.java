/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public class BattleResult {
    
    protected boolean gameOver;
    protected boolean victory;
    protected boolean retreat;
    protected Position winnerPosition;
    protected Position loserPosition;
    

    public BattleResult(){
        this.winnerPosition = new Position();
        this.loserPosition = new Position();
    }
    
    
    // Getters setters

    public Position getWinnerPosition() {
        return winnerPosition;
    }

    public void setWinnerPosition(Position winnerPosition) {
        this.winnerPosition = winnerPosition;
    }

    public Position getLoserPosition() {
        return loserPosition;
    }

    public void setLoserPosition(Position loserPosition) {
        this.loserPosition = loserPosition;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public boolean isRetreat() {
        return retreat;
    }

    public void setRetreat(boolean retreat) {
        this.retreat = retreat;
    }


    

}
