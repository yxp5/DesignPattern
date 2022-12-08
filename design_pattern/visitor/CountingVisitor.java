package design_pattern.visitor;

public class CountingVisitor implements Visitor {

    private int aCount = 0;

    @Override
    public void visitCalendar(Calendar pCalendar) {
        aCount += pCalendar.year().ordinal() + 1;
    }

    @Override
    public void visitCompositeCalendar(CompositeCalendar pComposite) {
        pComposite.content().forEach(compositeBase -> compositeBase.acceptVisitor(this));
    }

    public int count() {
        return aCount;
    }

    public void reset() {
        aCount = 0;
    }
}
