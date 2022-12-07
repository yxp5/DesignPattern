package design_pattern;

public class Client {
    
    public static Calendar calendar = new Calendar(Year.ONE);
    public static Calendar calendar2 = new Calendar(Year.TWO);
    public static Calendar calendar3 = new Calendar(Year.THREE);
    public static Calendar calendar4 = new Calendar(Year.FOUR);
    public static IteratingCalendar iteratingCalendar = new IteratingCalendar(Year.ONE);

    public static CompositeCalendar compositeCalendar = new CompositeCalendar(calendar, calendar2);
    public static CompositeCalendar compositeCalendar2 = new CompositeCalendar(calendar3, compositeCalendar);
    public static DecoratedCalendar decoratedCalendar = new DecoratedCalendar(compositeCalendar2);
    public static CompositeCalendar compositeCalendar3 = new CompositeCalendar(compositeCalendar2, decoratedCalendar, calendar4);

    public static void main(String[] args) {
        // Test on mixing decorator and composite
        System.out.println(compositeCalendar3.details());
    }
}
