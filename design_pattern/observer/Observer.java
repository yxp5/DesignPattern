package design_pattern.observer;

public interface Observer {

    Year year();

    // Use push data-flow strategy
    void newYear(Year pYear);

    // Use pull data-flow strategy
    void newYear(CalendarBase pBase);
}
