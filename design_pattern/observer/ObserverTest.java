package design_pattern.observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    public Calendar calendar = new Calendar(Year.ONE);

    // Try comment-out line 37 in Calendar to see the difference
    @Test
    void testingPushCorrectness() {
        calendar.changeYearPush(Year.TWO);
        calendar.observers().stream()
                .map(Observer::year)
                .forEach(year -> Assertions.assertSame(Year.TWO, year));
    }

    // Try comment-out line 51 in Calendar to see the difference
    @Test
    void testingPullCorrectness() {
        calendar.changeYearPull(Year.THREE);
        calendar.observers().stream()
                .map(Observer::year)
                .forEach(year -> Assertions.assertSame(Year.THREE, year));
    }
}
