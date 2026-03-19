package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split(". ");
        String[] rightStr = right.split(". ");
        int minLength = Math.min(leftStr.length, rightStr.length);
        for (int i = 0; i < minLength; i++) {
            if (!leftStr[i].equals(rightStr[i])) {
                return Integer.compare(Integer.parseInt(leftStr[i]), Integer.parseInt(rightStr[i]));
            }
        }
        return 0;
    }
}
