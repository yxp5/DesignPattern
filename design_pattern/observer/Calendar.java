package design_pattern.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Calendar implements CalendarBase {

    private final List<Observer> aObservers = new ArrayList<>();
    private Year aYear;

    public Calendar(Year pYear) {
        assert pYear != null;
        for (Month aMonth : Month.values()) {
            aObservers.add(new Date(aMonth, pYear));
        }
        aYear = pYear;
    }

    @Override
    public Year year() {
        return aYear;
    }

    // Push data-flow
    private void notifyObserversPush() {
        aObservers.forEach(observer -> observer.newYear(aYear));
    }

    public void changeYearPush(Year pYear) {
        assert pYear != null;
        if (aYear.equals(pYear)) {
            return;
        }
        aYear = pYear;
        notifyObserversPush();
    }

    // Pull data-flow
    private void notifyObserversPull() {
        aObservers.forEach(observer -> observer.newYear(this));
    }

    public void changeYearPull(Year pYear) {
        assert pYear != null;
        if (aYear.equals(pYear)) {
            return;
        }
        aYear = pYear;
        notifyObserversPull();
    }

    public List<Observer> observers() {
        return Collections.unmodifiableList(aObservers);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Observer observer : aObservers) {
            builder.append(observer.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
