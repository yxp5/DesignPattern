package design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private final List<Date> aMonths = new ArrayList<>();
    private final Year aYear;

    public Calendar(Year pYear) {
        assert pYear != null;
        for (Month aMonth : Month.values()) {
            aMonths.add(new Date(aMonth, pYear));
        }
        aYear = pYear;
    }

    public Year year() {
        return aYear;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Date date : aMonths) {
            builder.append(date.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
