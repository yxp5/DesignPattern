package design_pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratingCalendar implements Iterable<Date> {

    private final List<Date> aMonths = new ArrayList<>();
    private final Year aYear;

    public IteratingCalendar(Year pYear) {
        for (Month aMonth : Month.values()) {
            aMonths.add(new Date(aMonth, pYear));
        }
        aYear = pYear;
    }

    public Year year() {
        return aYear;
    }

    @Override
    public Iterator<Date> iterator() {
        return Collections.unmodifiableList(aMonths).iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Date> iterate = this.iterator();
        while (iterate.hasNext()) {
            builder.append(iterate.next().toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        IteratingCalendar iteratingCalendar = new IteratingCalendar(Year.ONE);
        System.out.println(iteratingCalendar);
    }
}
