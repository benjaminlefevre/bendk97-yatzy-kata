package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.DiceGroup.Pair;
import com.bendk97.kata.yatzy.model.Die;

import java.util.Set;

import static com.bendk97.kata.yatzy.service.score.category.GroupByFunctions.getPairs;


public final class TwoPairsScore extends AbstractCategoryScore {

    @Override
    protected int computeScore(Set<Die> dice) {
        Set<Pair> pairs = getPairs(dice);
        if(pairs.size() != 2) {
            return 0;
        }
        return pairs.stream()
              .map(Pair::sumPoints)
              .reduce(0, Integer::sum);
    }
}
