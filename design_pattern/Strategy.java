package design_pattern;

import java.util.*;

public class Strategy {

    public Strategy() {}

    public Comparator<Calendar> createByYearComparator() {
        return new Comparator<Calendar>() {
            @Override
            public int compare(Calendar pCalendar1, Calendar pCalendar2) {
                return pCalendar1.year().ordinal() - pCalendar2.year().ordinal();
            }
        };
    }

    public Comparator<Dates> createByMonthComparator(Month pMonth) {
        return new Comparator<Dates>() {
            @Override
            public int compare(Dates pDates1, Dates pDates2) {
                return countMonth(pDates2) - countMonth(pDates1);
            }

            private int countMonth(Dates pDates) {
                return pDates.sealedCopy().stream()
                        .filter(date -> date.sameMonthAs(pMonth))
                        .mapToInt(date -> 1)
                        .sum();
            }
        };
    }

    // Tests
    public static void main(String[] args) {

        // Testing byYearComparator
        Calendar calendar1 = new Calendar(Year.ONE);
        Calendar calendar2 = new Calendar(Year.TWO);
        Calendar calendar3 = new Calendar(Year.THREE);

        List<Calendar> CALENDARS = Arrays.asList(calendar3, calendar1, calendar2);
        CALENDARS.sort(new Strategy().createByYearComparator());

        // CALENDARS.forEach(System.out::println);

        // Testing byMonthComparator on Month.JAN
        Date date1 = new Date(Month.JAN, Year.ONE);
        Date date2 = new Date(Month.FEB, Year.ONE);
        Date date3 = new Date(Month.MAR, Year.ONE);
        Date date4 = new Date(Month.JAN, Year.TWO);
        Date date5 = new Date(Month.JAN, Year.THREE);
        Date date6 = new Date(Month.FEB, Year.THREE);

        Dates dates1 = new Dates(date1, date4, date5);           // 3 Jan
        Dates dates2 = new Dates(date1, date2, date3, date4);    // 2 Jan
        Dates dates3 = new Dates(date6);                         // 0 Jan

        List<Dates> DATES = Arrays.asList(dates1, dates2, dates3);
        DATES.sort(new Strategy().createByMonthComparator(Month.JAN));

        // DATES.forEach(System.out::println);
    }
}
