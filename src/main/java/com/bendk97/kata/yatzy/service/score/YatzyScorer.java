package com.bendk97.kata.yatzy.service.score;

import com.bendk97.kata.yatzy.model.Category;
import com.bendk97.kata.yatzy.model.Die;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class YatzyScorer {

    public int computeScore(Category category, Set<Die> dice) {
        return category.scores(dice);
    }

}
