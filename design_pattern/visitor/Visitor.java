package design_pattern.visitor;

public interface Visitor {

    void visitCalendar(Calendar pCalendar);
    void visitCompositeCalendar(CompositeCalendar pComposite);
}
