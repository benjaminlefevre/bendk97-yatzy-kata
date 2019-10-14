package com.bendk97.kata.yatzy.service.score.category.impl;

import com.bendk97.kata.yatzy.model.DiceGroup.FiveOfKind;
import com.bendk97.kata.yatzy.model.Die;
import com.bendk97.kata.yatzy.service.score.category.GroupByFunctions;

import java.util.Set;
import java.util.function.Function;


public final class YatzyScore extends AbstractGroupScore<FiveOfKind> {

    @Override
    protected Function<Set<Die>, Set<FiveOfKind>> groupByFunction() {
        return GroupByFunctions::getFiveOfKinds;
    }
}
