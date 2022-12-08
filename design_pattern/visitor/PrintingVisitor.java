package design_pattern.visitor;

public class PrintingVisitor implements Visitor {

    // Prove correctness using induction on the length of the composite graph

    private String aDetail = "";

    @Override
    public void visitCalendar(Calendar pCalendar) {
        // Simply print calendar, base case
        aDetail += pCalendar.toString();
    }

    @Override
    public void visitCompositeCalendar(CompositeCalendar pComposite) {
        // Traverse through all elements of pComposite, inductive step
        aDetail += "The following is composite:\n";
        pComposite.content().forEach(compositeBase -> compositeBase.acceptVisitor(this));
        aDetail += "End\n";
    }

    public String detail() {
        return aDetail;
    }

    public void reset() {
        aDetail = "";
    }
}
