package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.DiceGroup.FourOfKind;
import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.service.score.category.GroupByFunctions;

import java.util.Set;
import java.util.function.Function;


public final class FourOfKindScore extends AbstractGroupScore<FourOfKind> {

    @Override
    protected Function<Set<Die>, Set<FourOfKind>> groupByFunction() {
        return GroupByFunctions::getFourOfKinds;
    }
}
