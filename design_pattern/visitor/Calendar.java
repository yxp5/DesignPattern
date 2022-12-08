package design_pattern.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar implements CompositeBase {

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

    public List<Date> months() {
        return Collections.unmodifiableList(aMonths);
    }

    @Override
    public String toString() {
        // For simplicity, just return aYear
        return "Year " + aYear.name() + "\n";
    }

    @Override
    public void acceptVisitor(Visitor pVisitor) {
        pVisitor.visitCalendar(this);
    }
}
