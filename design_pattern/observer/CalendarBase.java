package design_pattern.observer;

public interface CalendarBase {

    // To maintain polymorphism and flexibility for future implementations in pull data-flow strategy
    Year year();
}
