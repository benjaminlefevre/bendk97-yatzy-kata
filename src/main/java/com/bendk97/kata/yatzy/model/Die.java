package com.bendk97.kata.yatzy.model;


import java.util.Optional;
import java.util.Set;
import org.apache.commons.lang3.NotImplementedException;

public class Die {

    private DieFace faceValue;

    private Die(DieFace value) {
        this.faceValue = value;
    }

    public void roll() {
        throw new NotImplementedException("Will be implemented later!");
    }

    public DieFace getFaceValue() {
        return faceValue;
    }

    public Integer getPoints() {
        return Optional.ofNullable(faceValue).map(DieFace::getPoints).orElse(0);
    }

    public static Set<Die> simulateRollingOfFiveDice(DieFace d1, DieFace d2, DieFace d3, DieFace d4, DieFace d5) {
        return Set.of(new Die(d1), new Die(d2), new Die(d3), new Die(d4), new Die(d5));
    }
}
