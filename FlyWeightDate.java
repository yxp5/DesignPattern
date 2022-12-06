package design_pattern;

public class FlyWeightDate {

    // A FlyWeight for all possible dates
    private static final FlyWeightDate[][] FLYWEIGHT_DATE =
            new FlyWeightDate[Month.values().length][Year.values().length];

    private final Month aMonth;
    private final Year aYear;

    private FlyWeightDate(Month pMonth, Year pYear) {
        assert pMonth != null && pYear != null;
        aMonth = pMonth;
        aYear = pYear;
    }

    public static FlyWeightDate getDate(Month pMonth, Year pYear) {
        // Use lazy initialization
        if (FLYWEIGHT_DATE[pMonth.ordinal()][pYear.ordinal()] == null) {
            FLYWEIGHT_DATE[pMonth.ordinal()][pYear.ordinal()] = new FlyWeightDate(pMonth, pYear);
        }
        return FLYWEIGHT_DATE[pMonth.ordinal()][pYear.ordinal()];
    }

    public Month month() {
        return aMonth;
    }

    public Year year() {
        return aYear;
    }

    public static void main(String[] args) {
        for (Year pYear : Year.values()) {
            for (Month pMonth : Month.values()) {
                System.out.println(getDate(pMonth, pYear));
            }
        }
    }
}
