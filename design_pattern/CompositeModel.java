package design_pattern;

public class CompositeModel {

    private final CompositeBase aPrototype;
    private CompositeBase aCompositeBase;

    public CompositeModel(CompositeBase pPrototype) {
        aPrototype = pPrototype;
        newComposite();
    }

    public void newComposite() {
        aCompositeBase = aPrototype.copy();
    }

    @Override
    public String toString() {
        return aCompositeBase.details();
    }
}
