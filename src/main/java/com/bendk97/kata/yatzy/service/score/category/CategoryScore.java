package com.bendk97.kata.yatzy.service.score.category;

import com.bendk97.kata.yatzy.model.Die;
import java.util.Set;

public interface CategoryScore {
    int scores(Set<Die> dice);
}
