package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.Die;

import java.util.Set;

public final class ChanceScore extends AbstractCategoryScore {

    @Override
    protected int computeScore(Set<Die> dice) {
        return dice
              .stream()
              .mapToInt(Die::getPoints)
              .sum();
    }
}
