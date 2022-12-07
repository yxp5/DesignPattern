package design_pattern;

import java.util.ArrayList;
import java.util.List;

public class SingletonCalendar {

    private static final SingletonCalendar INSTANCE = new SingletonCalendar();
    private final List<Date> aMonths = new ArrayList<>();
    private Year aYear;

    private SingletonCalendar() {
        // Default year starts at Year.ONE
        newCalendar(Year.ONE);
    }

    public void newCalendar(Year pYear) {
        assert pYear != null;
        aMonths.clear();
        aYear = pYear;
        for (Month aMonth : Month.values()) {
            aMonths.add(new Date(aMonth, pYear));
        }
    }

    public Year year() {return aYear;}

    public static SingletonCalendar instance() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Date date : aMonths) {
            builder.append(date.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // Test for singleton property
        SingletonCalendar INSTANCE = SingletonCalendar.instance();
        System.out.println(INSTANCE);

        INSTANCE.newCalendar(Year.FIVE);
        System.out.println(INSTANCE);

        SingletonCalendar INSTANCE2 = SingletonCalendar.instance();
        System.out.println(INSTANCE2);
        System.out.println(INSTANCE == INSTANCE2);
    }
}
