package com.bendk97.kata.yatzy.model;

import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toSet;

/**
 *  dice set with the same face value
 */
public abstract class DiceGroup {

    private final Set<Die> dice;
    private final DieFace faceValue;

    DiceGroup(Set<Die> dice) {
        checkArgument(dice.size() == getGroupSize());
        checkArgument(dice.stream().map(Die::getFaceValue).collect(toSet()).size() == 1);
        this.faceValue = dice.stream().map(Die::getFaceValue).findFirst().orElseThrow();
        this.dice = dice;
    }

    public abstract int getGroupSize();

    public int sumPoints() {
        return getGroupSize() * faceValue.getPoints();
    }

    public DieFace getFaceValue() {
        return faceValue;
    }

    public Set<Die> getDice() {
        return dice;
    }

    public static class Pair extends DiceGroup {
        public Pair(Set<Die> dice) {
            super(dice);
        }

        @Override
        public int getGroupSize() {
            return 2;
        }
    }

    public static class ThreeOfKind extends DiceGroup {
        public ThreeOfKind(Set<Die> dice) {
            super(dice);
        }

        @Override
        public int getGroupSize() {
            return 3;
        }
    }

    public static class FourOfKind extends DiceGroup {
        public FourOfKind(Set<Die> dice) {
            super(dice);
        }

        @Override
        public int getGroupSize() {
            return 4;
        }
    }

    public static class FiveOfKind extends DiceGroup {
        public FiveOfKind(Set<Die> dice) {
            super(dice);
        }

        @Override
        public int getGroupSize() {
            return 5;
        }

        @Override
        public int sumPoints() {
            return 50;
        }
    }

}
