package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.model.DieFace;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractDieFaceScore extends AbstractCategoryScore {

    private final DieFace dieFace;

    protected AbstractDieFaceScore(DieFace dieFace) {
        this.dieFace = dieFace;
    }

    @Override
    protected int computeScore(Set<Die> dice) {
        return dice
              .stream()
              .filter(die -> Objects.equals(die.getFaceValue(), dieFace))
              .mapToInt(Die::getPoints)
              .sum();
    }
}
