package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.DiceGroup.Pair;
import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.service.score.category.GroupByFunctions;

import java.util.Set;
import java.util.function.Function;


public final class PairScore extends AbstractGroupScore<Pair> {

    @Override
    protected Function<Set<Die>, Set<Pair>> groupByFunction() {
        return GroupByFunctions::getPairs;
    }
}
