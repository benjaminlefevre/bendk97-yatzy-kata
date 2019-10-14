package com.bendk97.kata.yatzy.service.score.category.impl;

import static com.bendk97.kata.yatzy.model.DieFace.FIVE;
import static com.bendk97.kata.yatzy.model.DieFace.FOUR;
import static com.bendk97.kata.yatzy.model.DieFace.SIX;
import static com.bendk97.kata.yatzy.model.DieFace.THREE;
import static com.bendk97.kata.yatzy.model.DieFace.TWO;

import java.util.Set;


public final class LargeStraightScore extends AbstractStraightScore {

    public LargeStraightScore() {
        super(Set.of(TWO, THREE, FOUR, FIVE, SIX), 20);
    }
}
