package design_pattern.visitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTest {

    public Calendar calendar = new Calendar(Year.ONE);
    public Calendar calendar2 = new Calendar(Year.TWO);
    public Calendar calendar3 = new Calendar(Year.THREE);
    public Calendar calendar4 = new Calendar(Year.FOUR);

    public CompositeCalendar compositeCalendar = new CompositeCalendar(calendar, calendar2);
    public CompositeCalendar compositeCalendar2 = new CompositeCalendar(calendar3, compositeCalendar);
    public CompositeCalendar compositeCalendar3 = new CompositeCalendar(compositeCalendar2, calendar4);

    public PrintingVisitor printer = new PrintingVisitor();
    public CountingVisitor counter = new CountingVisitor();

    public String compositeCalendar3Detail = """
            The following is composite:
            The following is composite:
            Year THREE
            The following is composite:
            Year ONE
            Year TWO
            End
            End
            Year FOUR
            End
            """;

    @Test
    void testingPrinterCorrectness() {
        compositeCalendar3.acceptVisitor(printer);
        Assertions.assertEquals(compositeCalendar3Detail, printer.detail());
    }

    @Test
    void testingPrinterReset() {
        compositeCalendar3.acceptVisitor(printer);
        printer.reset();
        Assertions.assertEquals("", printer.detail());
    }

    @Test
    void testingCounterCorrectness() {
        compositeCalendar3.acceptVisitor(counter);
        Assertions.assertSame(10, counter.count());
    }

    @Test
    void testingCounterReset() {
        compositeCalendar3.acceptVisitor(counter);
        counter.reset();
        Assertions.assertSame(0, counter.count());
    }
}
