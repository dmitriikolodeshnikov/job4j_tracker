package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {

    @Test
    public void when30and54Then4Point472() {
        Point a = new Point(3, 0);
        Point b = new Point(5, 4);
        double rsl = a.distance3d(b);
        double expected = 4.472;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when03and54Then5Point099() {
        Point a = new Point(0, 3);
        Point b = new Point(5, 4);
        double rsl = a.distance3d(b);
        double expected = 5.099;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when030and540Then5Point099() {
        Point a = new Point(0, 3, 0);
        Point b = new Point(5, 4, 0);
        double rsl = a.distance3d(b);
        double expected = 5.099;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when000and400Then8() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double rsl = a.distance3d(b);
        double expected = 4;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}