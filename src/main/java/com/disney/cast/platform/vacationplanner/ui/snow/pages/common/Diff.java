package com.disney.cast.platform.vacationplanner.ui.snow.pages.common;

import java.util.ArrayList;
import java.util.List;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

public class Diff {

    static public boolean sameElements(List<? extends ValueObject> first, List<? extends ValueObject> second) {
        return second.containsAll(first) && first.containsAll(second);
    }

    static public Difference difference(List<? extends ValueObject> first, List<? extends ValueObject> second) {
        List<ValueObject> firstCopy = new ArrayList<>(first);
        List<ValueObject> secondCopy = new ArrayList<>(second);
        firstCopy.removeAll(second);
        secondCopy.removeAll(first);
        return new Difference(firstCopy, secondCopy);
    }

    public static class Difference {
        final public List<ValueObject> first;
        final public List<ValueObject> second;

        public Difference(List<ValueObject> first, List<ValueObject> second) {
            this.first = first;
            this.second = second;
        }
    }
}