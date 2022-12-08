package design_pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TemplateBlank implements CompositeBase {

    private final List<Date> aMonths = new ArrayList<>();
    private final Year aYear;

    protected TemplateBlank(Year pYear) {
        assert pYear != null;
        for (Month aMonth : Month.values()) {
            aMonths.add(new Date(aMonth, pYear));
        }
        aYear = pYear;
    }

    // Getters declared final, so not to be over-written
    public final List<Date> months() {
        return Collections.unmodifiableList(aMonths);
    }

    public final Year year() {
        return aYear;
    }

    // yearQuote() may vary from subclasses
    protected abstract String yearQuote();
}