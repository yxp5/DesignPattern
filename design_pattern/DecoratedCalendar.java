package design_pattern;

public class DecoratedCalendar implements CompositeBase {

    private final CompositeBase aElement;

    public DecoratedCalendar(CompositeBase pElement) {
        aElement = pElement;
    }

    @Override
    public String details() {
        return "The following is decorated:\n" + aElement.details() + "End\n";
    }

    @Override
    public String toString() {return details();}

    @Override
    public DecoratedCalendar copy() {
        return new DecoratedCalendar(aElement.copy());
    }

    public static void main(String[] args) {
        CompositeBase compositeBase = new DecoratedCalendar(new CompositeCalendar(new Calendar(Year.SEVEN), new Calendar(Year.NINE)));
        System.out.println(compositeBase);
    }
}
