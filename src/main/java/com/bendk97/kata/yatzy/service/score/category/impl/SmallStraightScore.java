package com.bendk97.kata.yatzy.service.score.category.impl;

import static com.bendk97.kata.yatzy.model.DieFace.FIVE;
import static com.bendk97.kata.yatzy.model.DieFace.FOUR;
import static com.bendk97.kata.yatzy.model.DieFace.ONE;
import static com.bendk97.kata.yatzy.model.DieFace.THREE;
import static com.bendk97.kata.yatzy.model.DieFace.TWO;

import java.util.Set;


public final class SmallStraightScore extends AbstractStraightScore {

    public SmallStraightScore() {
        super(Set.of(ONE, TWO, THREE, FOUR, FIVE), 15);
    }
}
