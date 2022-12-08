package design_pattern.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<CompositeBase> content() {
        return Collections.unmodifiableList(aComposite);
    }

    @Override
    public void acceptVisitor(Visitor pVisitor) {
        pVisitor.visitCompositeCalendar(this);
    }
}
