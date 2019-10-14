package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.DiceGroup.Pair;
import com.bendk97.kata.yatzy.model.DiceGroup.ThreeOfKind;
import com.bendk97.kata.yatzy.model.Die;

import java.util.Optional;
import java.util.Set;

import static com.bendk97.kata.yatzy.service.score.category.GroupByFunctions.getPairs;
import static com.bendk97.kata.yatzy.service.score.category.GroupByFunctions.getThreeOfKinds;
import static com.google.common.collect.Sets.difference;


public final class FullHouseScore extends AbstractCategoryScore {

    @Override
    protected int computeScore(Set<Die> dice) {
        ThreeOfKind threeOfKind = getThreeOfKinds(dice).stream().findFirst().orElse(null);
        if(Optional.ofNullable(threeOfKind).isEmpty()) {
            return 0;
        }
        // lookup pair after removing threeOfKind
        Pair pair = getPairs(difference(dice, threeOfKind.getDice())).stream().findFirst().orElse(null);
        if(Optional.ofNullable(pair).isEmpty()) {
            return 0;
        }

        return threeOfKind.sumPoints() + pair.sumPoints();
    }
}
