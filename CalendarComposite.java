package design_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarComposite implements CompositeBase {

    private final List<CompositeBase> aComposite = new ArrayList<>();

    public CalendarComposite(CompositeBase... pComposite) {
        aComposite.addAll(Arrays.asList(pComposite));
    }

    public void add(CompositeBase pComposite) {
        assert pComposite != null;
        aComposite.add(pComposite);
    }

    @Override
    public String details() {
        return aComposite.stream()
                .map(CompositeBase::details)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        // Test for composite recursion correctness
        CalendarComposite calendarComposite = new CalendarComposite();
        calendarComposite.add(new Calendar(Year.ONE));
        calendarComposite.add(new CalendarComposite(new Calendar(Year.FIVE), new Calendar(Year.ONE)));
        calendarComposite.add(new Calendar(Year.THREE));

        System.out.println(calendarComposite.details());
    }
}
