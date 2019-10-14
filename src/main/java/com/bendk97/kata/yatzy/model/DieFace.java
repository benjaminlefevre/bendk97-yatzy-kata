package com.bendk97.kata.yatzy.model;

/**
 * a Die has faces, each face is associated to points
 */
public enum DieFace {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    private int points;

    DieFace(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }
}
