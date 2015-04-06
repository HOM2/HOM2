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
    protected Position winnerPosition;
    protected Position loserPosition;
    

    public BattleResult(){
    
    }
    
    
    // Getters setters
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

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

    boolean isRetreat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
