package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.service.score.category.CategoryScore;

import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

/**
 * The top-level class
 */
public abstract class AbstractCategoryScore implements CategoryScore {

    @Override
    public int scores(Set<Die> dice) {
        checkdice(dice);
        return computeScore(dice);
    }

    private void checkdice(Set<Die> dice) {
        checkArgument(
                isNotEmpty(dice)
                        && dice.size() == 5
                        && dice.stream().noneMatch(die -> Optional.ofNullable(die.getFaceValue()).isEmpty()));
    }

    protected abstract int computeScore(Set<Die> dice);
}
