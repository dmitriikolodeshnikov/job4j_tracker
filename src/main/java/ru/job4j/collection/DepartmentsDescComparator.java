package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator  implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split("/");
        String[] rightStr = right.split("/");
        int result = 0;
        int minLength = Math.min(leftStr.length, rightStr.length);
        for (int i = 0; i < minLength; i++) {
            if (i == 0) {
                result =  rightStr[i].compareTo(leftStr[i]);

            } else {
                result =  leftStr[i].compareTo(rightStr[i]);
            }
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftStr.length, rightStr.length);
    }
}
