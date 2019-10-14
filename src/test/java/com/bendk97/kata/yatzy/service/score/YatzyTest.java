package com.bendk97.kata.yatzy.service.score;

import static com.bendk97.kata.yatzy.model.Category.CHANCE;
import static com.bendk97.kata.yatzy.model.Category.FIVES;
import static com.bendk97.kata.yatzy.model.Category.FOURS;
import static com.bendk97.kata.yatzy.model.Category.FOUR_OF_A_KIND;
import static com.bendk97.kata.yatzy.model.Category.FULL_HOUSE;
import static com.bendk97.kata.yatzy.model.Category.LARGE_STRAIGHT;
import static com.bendk97.kata.yatzy.model.Category.ONES;
import static com.bendk97.kata.yatzy.model.Category.PAIR;
import static com.bendk97.kata.yatzy.model.Category.SIXES;
import static com.bendk97.kata.yatzy.model.Category.SMALL_STRAIGHT;
import static com.bendk97.kata.yatzy.model.Category.THREES;
import static com.bendk97.kata.yatzy.model.Category.THREE_OF_A_KIND;
import static com.bendk97.kata.yatzy.model.Category.TWOS;
import static com.bendk97.kata.yatzy.model.Category.TWO_PAIRS;
import static com.bendk97.kata.yatzy.model.Category.YATZY;
import static com.bendk97.kata.yatzy.model.Die.simulateRollingOfFiveDice;
import static com.bendk97.kata.yatzy.model.DieFace.FIVE;
import static com.bendk97.kata.yatzy.model.DieFace.FOUR;
import static com.bendk97.kata.yatzy.model.DieFace.ONE;
import static com.bendk97.kata.yatzy.model.DieFace.SIX;
import static com.bendk97.kata.yatzy.model.DieFace.THREE;
import static com.bendk97.kata.yatzy.model.DieFace.TWO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = YatzyScorer.class)
public class YatzyTest {

    @Autowired
    YatzyScorer scorer;

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertThat(scorer.computeScore(CHANCE, simulateRollingOfFiveDice(TWO, THREE, FOUR, FIVE, ONE))).isEqualTo(15);
        assertThat(scorer.computeScore(CHANCE, simulateRollingOfFiveDice(THREE, THREE, FOUR, FIVE, ONE))).isEqualTo(16);
    }

    @Test
    public void yatzy_scores_50() {
        assertThat(scorer.computeScore(YATZY, simulateRollingOfFiveDice(SIX, SIX, SIX, SIX, SIX))).isEqualTo(50);
        assertThat(scorer.computeScore(YATZY, simulateRollingOfFiveDice(SIX, SIX, SIX, SIX, THREE))).isEqualTo(0);
    }

    @Test
    public void test_1s() {
        assertThat(scorer.computeScore(ONES, simulateRollingOfFiveDice(ONE, TWO, THREE, FOUR, FIVE))).isEqualTo(1);
        assertThat(scorer.computeScore(ONES, simulateRollingOfFiveDice(ONE, TWO, ONE, FOUR, FIVE))).isEqualTo(2);
        assertThat(scorer.computeScore(ONES, simulateRollingOfFiveDice(SIX, TWO, TWO, FOUR, FIVE))).isEqualTo(0);
        assertThat(scorer.computeScore(ONES, simulateRollingOfFiveDice(ONE, TWO, ONE, ONE, ONE))).isEqualTo(4);
    }

    @Test
    public void test_2s() {
        assertThat(scorer.computeScore(TWOS, simulateRollingOfFiveDice(ONE, TWO, THREE, TWO, SIX))).isEqualTo(4);
        assertThat(scorer.computeScore(TWOS, simulateRollingOfFiveDice(TWO, TWO, TWO, TWO, TWO))).isEqualTo(10);
    }

    @Test
    public void test_threes() {
        assertThat(scorer.computeScore(THREES, simulateRollingOfFiveDice(ONE, TWO, THREE, TWO, THREE))).isEqualTo(6);
        assertThat(scorer.computeScore(THREES, simulateRollingOfFiveDice(TWO, THREE, THREE, THREE, THREE))).isEqualTo(12);
    }

    @Test
    public void fours_test() {
        assertThat(scorer.computeScore(FOURS, simulateRollingOfFiveDice(FOUR, FOUR, FOUR, FIVE, FIVE))).isEqualTo(12);
        assertThat(scorer.computeScore(FOURS, simulateRollingOfFiveDice(FOUR, FOUR, FIVE, FIVE, FIVE))).isEqualTo(8);
        assertThat(scorer.computeScore(FOURS, simulateRollingOfFiveDice(FOUR, FIVE, FIVE, FIVE, FIVE))).isEqualTo(4);
    }

    @Test
    public void fives() {
        assertThat(scorer.computeScore(FIVES, simulateRollingOfFiveDice(FOUR, FOUR, FOUR, FIVE, FIVE))).isEqualTo(10);
        assertThat(scorer.computeScore(FIVES, simulateRollingOfFiveDice(FOUR, FOUR, FIVE, FIVE, FIVE))).isEqualTo(15);
        assertThat(scorer.computeScore(FIVES, simulateRollingOfFiveDice(FOUR, FIVE, FIVE, FIVE, FIVE))).isEqualTo(20);
    }

    @Test
    public void sixes_test() {
        assertThat(scorer.computeScore(SIXES, simulateRollingOfFiveDice(FOUR, FOUR, FOUR, FIVE, FIVE))).isEqualTo(0);
        assertThat(scorer.computeScore(SIXES, simulateRollingOfFiveDice(FOUR, FOUR, SIX, FIVE, FIVE))).isEqualTo(6);
        assertThat(scorer.computeScore(SIXES, simulateRollingOfFiveDice(SIX, FIVE, SIX, SIX, FIVE))).isEqualTo(18);
    }

    @Test
    public void one_pair() {
        assertThat(scorer.computeScore(PAIR, simulateRollingOfFiveDice(SIX, FIVE, FOUR, TWO, ONE))).isEqualTo(0);
        assertThat(scorer.computeScore(PAIR, simulateRollingOfFiveDice(THREE, FOUR, THREE, FIVE, SIX))).isEqualTo(6);
        assertThat(scorer.computeScore(PAIR, simulateRollingOfFiveDice(FIVE, THREE, THREE, THREE, FIVE))).isEqualTo(10);
        assertThat(scorer.computeScore(PAIR, simulateRollingOfFiveDice(FIVE, THREE, SIX, SIX, FIVE))).isEqualTo(12);
    }

    @Test
    public void two_Pair() {
        assertThat(scorer.computeScore(TWO_PAIRS, simulateRollingOfFiveDice(THREE, THREE, FIVE, FOUR, FIVE))).isEqualTo(16);
        assertThat(scorer.computeScore(TWO_PAIRS, simulateRollingOfFiveDice(THREE, THREE, FIVE, FIVE, FIVE))).isEqualTo(16);
        assertThat(scorer.computeScore(TWO_PAIRS, simulateRollingOfFiveDice(ONE, ONE, TWO, THREE, FOUR))).isEqualTo(0);
        // There was a bug in the initial code, specifications does not disallow two pairs with the same number
        assertThat(scorer.computeScore(TWO_PAIRS, simulateRollingOfFiveDice(ONE, ONE, TWO, ONE, ONE))).isEqualTo(4);
    }

    @Test
    public void three_of_a_kind() {
        assertThat(scorer.computeScore(THREE_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, THREE, FOUR, FIVE)))
              .isEqualTo(9);
        assertThat(scorer.computeScore(THREE_OF_A_KIND, simulateRollingOfFiveDice(FIVE, THREE, FIVE, FOUR, FIVE)))
              .isEqualTo(15);
        assertThat(scorer.computeScore(THREE_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, THREE, THREE, FIVE)))
              .isEqualTo(9);
        assertThat(scorer.computeScore(THREE_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, ONE, TWO, FIVE))).isEqualTo(0);
    }

    @Test
    public void four_of_a_knd() {
        assertThat(scorer.computeScore(FOUR_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, THREE, THREE, FIVE)))
              .isEqualTo(12);
        assertThat(scorer.computeScore(FOUR_OF_A_KIND, simulateRollingOfFiveDice(FIVE, FIVE, FIVE, FOUR, FIVE)))
              .isEqualTo(20);
        assertThat(scorer.computeScore(FOUR_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, THREE, THREE, THREE)))
              .isEqualTo(12);
        assertThat(scorer.computeScore(FOUR_OF_A_KIND, simulateRollingOfFiveDice(THREE, THREE, THREE, ONE, ONE)))
              .isEqualTo(0);
    }

    @Test
    public void smallStraight() {
        assertThat(scorer.computeScore(SMALL_STRAIGHT, simulateRollingOfFiveDice(ONE, TWO, THREE, FOUR, FIVE))).isEqualTo(15);
        assertThat(scorer.computeScore(SMALL_STRAIGHT, simulateRollingOfFiveDice(TWO, THREE, FOUR, FIVE, ONE))).isEqualTo(15);
        assertThat(scorer.computeScore(SMALL_STRAIGHT, simulateRollingOfFiveDice(ONE, TWO, TWO, FOUR, FIVE))).isEqualTo(0);
    }

    @Test
    public void largeStraight() {
        assertThat(scorer.computeScore(LARGE_STRAIGHT, simulateRollingOfFiveDice(SIX, TWO, THREE, FOUR, FIVE))).isEqualTo(20);
        assertThat(scorer.computeScore(LARGE_STRAIGHT, simulateRollingOfFiveDice(TWO, THREE, FOUR, FIVE, SIX))).isEqualTo(20);
        assertThat(scorer.computeScore(LARGE_STRAIGHT, simulateRollingOfFiveDice(ONE, TWO, THREE, FOUR, FIVE))).isEqualTo(0);
    }

    @Test
    public void fullHouse() {
        assertThat(scorer.computeScore(FULL_HOUSE, simulateRollingOfFiveDice(SIX, TWO, TWO, TWO, SIX))).isEqualTo(18);
        assertThat(scorer.computeScore(FULL_HOUSE, simulateRollingOfFiveDice(TWO, THREE, FOUR, FIVE, SIX))).isEqualTo(0);
        assertThat(scorer.computeScore(FULL_HOUSE, simulateRollingOfFiveDice(TWO, TWO, FOUR, FOUR, SIX))).isEqualTo(0);
        assertThat(scorer.computeScore(FULL_HOUSE, simulateRollingOfFiveDice(TWO, TWO, TWO, TWO, TWO))).isEqualTo(10);
    }

    @Test
    public void one_die_has_no_face_after_rolling() {
        assertThatThrownBy(() -> scorer.computeScore(FULL_HOUSE, simulateRollingOfFiveDice(SIX, TWO, TWO, TWO, null)));
    }
}
