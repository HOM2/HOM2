/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */
public class CmdBtlAttack extends CmdBtl {

    protected Position attacker;
    protected Position defender;

    public CmdBtlAttack(GameController gc, Position attacker, Position defender) {
        super(gc);
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public void execute() {
        
    }

}
