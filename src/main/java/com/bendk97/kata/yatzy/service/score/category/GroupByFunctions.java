package com.bendk97.kata.yatzy.service.score.category;

import com.bendk97.kata.yatzy.model.DiceGroup;
import com.bendk97.kata.yatzy.model.DiceGroup.FiveOfKind;
import com.bendk97.kata.yatzy.model.DiceGroup.FourOfKind;
import com.bendk97.kata.yatzy.model.DiceGroup.Pair;
import com.bendk97.kata.yatzy.model.DiceGroup.ThreeOfKind;
import com.bendk97.kata.yatzy.model.Die;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static com.google.common.collect.Lists.partition;
import static java.util.stream.Collectors.groupingBy;

public class GroupByFunctions {


    private static <T extends DiceGroup> Set<T> getDiceSameValueGroups(Set<Die> dice, Function<Set<Die>, T> constructor, int groupSize) {
        Set<T> diceGroupList = new HashSet<>();
        dice.stream()
                .collect(groupingBy(Die::getFaceValue))
                .forEach((dieFace, diceWithSameDieFace) ->
                        partition(diceWithSameDieFace, groupSize)
                                .stream()
                                .filter(group -> group.size() == groupSize)
                                .forEach(groupDice -> diceGroupList.add(constructor.apply(new HashSet<>(groupDice)))));
        return diceGroupList;
    }

    public static Set<Pair> getPairs(Set<Die> dice) {
        return getDiceSameValueGroups(dice, Pair::new, 2);
    }

    public static Set<ThreeOfKind> getThreeOfKinds(Set<Die> dice) {
        return getDiceSameValueGroups(dice, ThreeOfKind::new, 3);
    }

    public static Set<FourOfKind> getFourOfKinds(Set<Die> dice) {
        return getDiceSameValueGroups(dice, FourOfKind::new, 4);
    }

    public static Set<FiveOfKind> getFiveOfKinds(Set<Die> dice) {
        return getDiceSameValueGroups(dice, FiveOfKind::new, 5);
    }

}
