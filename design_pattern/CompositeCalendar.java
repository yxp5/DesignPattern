package design_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeCalendar implements CompositeBase {

    private final List<CompositeBase> aComposite = new ArrayList<>();

    public CompositeCalendar(CompositeBase... pComposite) {
        aComposite.addAll(Arrays.asList(pComposite));
    }

    public void add(CompositeBase pComposite) {
        assert pComposite != null;
        aComposite.add(pComposite);
    }

    @Override
    public String details() {
        return "The following is composite:\n" +
                aComposite.stream()
                .map(CompositeBase::details)
                .collect(Collectors.joining()) + "End\n";
    }

    public static void main(String[] args) {
        // Test for composite recursion correctness
        CompositeCalendar compositeCalendar = new CompositeCalendar();
        compositeCalendar.add(new Calendar(Year.ONE));
        compositeCalendar.add(new CompositeCalendar(new Calendar(Year.FIVE), new Calendar(Year.ONE)));
        compositeCalendar.add(new Calendar(Year.THREE));

        System.out.println(compositeCalendar.details());
    }
}
