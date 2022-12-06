package design_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// An arbitrary list of Date used in Strategy
public class Dates {

    private final List<Date> aDates = new ArrayList<>();

    public Dates() {}

    public Dates(Date... pDates) {
        addAll(pDates);
    }

    public void add(Date pDate) {
        assert pDate != null;
        aDates.add(pDate);
    }

    public void addAll(Date... pDates) {
        assert pDates != null;
        aDates.addAll(Arrays.asList(pDates));
    }

    public List<Date> sealedCopy() {
        return Collections.unmodifiableList(aDates);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Date date : aDates) {
            builder.append(date.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
