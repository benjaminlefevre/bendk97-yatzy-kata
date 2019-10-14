package com.bendk97.kata.yatzy.service.score.category.impl;

import static java.util.stream.Collectors.toSet;

import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.model.DieFace;
import java.util.Set;

public abstract class AbstractStraightScore extends AbstractCategoryScore {

    private final Set<DieFace> straightFaces;
    private final int score;

    protected AbstractStraightScore(Set<DieFace> faces, int score) {
        this.straightFaces = faces;
        this.score = score;
    }

    @Override
    protected int computeScore(Set<Die> dice) {
        return dice
              .stream()
              .map(Die::getFaceValue)
              .collect(toSet())
              .equals(straightFaces) ? score : 0;
    }

}
