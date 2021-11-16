package org.example.design.behavioral.memento.simple;

import lombok.Data;

/**
 *  游戏角色发起人：实现发起人接口
 *
 * Author: GL
 * Date: 2021-11-15
 */
@Data
public class GameRole implements Originator<GameRole> {

    // 角色蓝量红量
    private double blueQuantity;
    private double redQuantity;

    public GameRole(double blueQuantity, double redQuantity) {
        this.blueQuantity = blueQuantity;
        this.redQuantity = redQuantity;
    }

    // 战斗
    public void fight() {
        this.blueQuantity -= 10;
        this.redQuantity -= 10;
    }

    @Override
    public Memento<GameRole> createMemento() {
        return new Memento<>(new GameRole(this.blueQuantity, this.redQuantity));
    }

    @Override
    public void restoreMemento(Memento<GameRole> memento) {
        this.blueQuantity = memento.getState().getBlueQuantity();
        this.redQuantity = memento.getState().getRedQuantity();
    }
}
