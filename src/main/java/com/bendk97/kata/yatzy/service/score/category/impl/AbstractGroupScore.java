package com.bendk97.kata.yatzy.service.score.category.impl;

import static java.util.Comparator.comparingInt;

import com.bendk97.kata.yatzy.model.DiceGroup;
import com.bendk97.kata.yatzy.model.Die;
import java.util.Set;
import java.util.function.Function;

public abstract class AbstractGroupScore<T extends DiceGroup> extends AbstractCategoryScore {

    @Override
    protected int computeScore(Set<Die> dice) {
        return groupByFunction().apply(dice)
              .stream()
              .max(comparingInt(group -> group.getFaceValue().getPoints()))
              .map(DiceGroup::sumPoints)
              .orElse(0);
    }

    protected abstract Function<Set<Die>, Set<T>> groupByFunction();
}
