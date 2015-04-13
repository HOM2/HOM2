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
public class CmdFactoryBtl extends CmdFactory {

    public static enum CmdType {

        RETREAT, ATTACK, HEAL
    }

    public CmdFactoryBtl(GameController gc) {
        super(gc);
    }

    @Override
    public CmdGame createCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CmdBtlHeal createHealCommand() {
        return new CmdBtlHeal(this.gameController);
    }

    public CmdBtlRetreat createRetreatCommand(GameSettings.Direction d) {
        return new CmdBtlRetreat(this.gameController, d);
    }

    public CmdBtlAttack createAttackCommand(Position attacker, Position defender) {
        return new CmdBtlAttack(this.gameController, attacker, defender);
    }

}
