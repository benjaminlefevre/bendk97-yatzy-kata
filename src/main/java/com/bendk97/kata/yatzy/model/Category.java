package com.bendk97.kata.yatzy.model;

import com.bendk97.kata.yatzy.service.score.category.CategoryScore;
import com.bendk97.kata.yatzy.service.score.category.impl.ChanceScore;
import com.bendk97.kata.yatzy.service.score.category.impl.FivesScore;
import com.bendk97.kata.yatzy.service.score.category.impl.FourOfKindScore;
import com.bendk97.kata.yatzy.service.score.category.impl.FoursScore;
import com.bendk97.kata.yatzy.service.score.category.impl.FullHouseScore;
import com.bendk97.kata.yatzy.service.score.category.impl.LargeStraightScore;
import com.bendk97.kata.yatzy.service.score.category.impl.OnesScore;
import com.bendk97.kata.yatzy.service.score.category.impl.PairScore;
import com.bendk97.kata.yatzy.service.score.category.impl.SixesScore;
import com.bendk97.kata.yatzy.service.score.category.impl.SmallStraightScore;
import com.bendk97.kata.yatzy.service.score.category.impl.ThreeOfKindScore;
import com.bendk97.kata.yatzy.service.score.category.impl.ThreesScore;
import com.bendk97.kata.yatzy.service.score.category.impl.TwoPairsScore;
import com.bendk97.kata.yatzy.service.score.category.impl.TwosScore;
import com.bendk97.kata.yatzy.service.score.category.impl.YatzyScore;
import java.util.Set;

public enum Category implements CategoryScore {
    CHANCE(new ChanceScore()),
    YATZY(new YatzyScore()),
    ONES(new OnesScore()),
    TWOS(new TwosScore()),
    THREES(new ThreesScore()),
    FOURS(new FoursScore()),
    FIVES(new FivesScore()),
    SIXES(new SixesScore()),
    PAIR(new PairScore()),
    TWO_PAIRS(new TwoPairsScore()),
    THREE_OF_A_KIND(new ThreeOfKindScore()),
    FOUR_OF_A_KIND(new FourOfKindScore()),
    SMALL_STRAIGHT(new SmallStraightScore()),
    LARGE_STRAIGHT(new LargeStraightScore()),
    FULL_HOUSE(new FullHouseScore());

    private CategoryScore scorer;

    Category(CategoryScore scorer) {
        this.scorer = scorer;
    }

    @Override
    public int scores(Set<Die> dice) {
        return scorer.scores(dice);
    }
}
