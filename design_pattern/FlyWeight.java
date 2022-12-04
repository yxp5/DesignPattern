package design_pattern;

public class FlyWeight {

    // A FlyWeight for all possible dates
    private static final Date[][] aFlyWeight = new Date[Month.values().length][Year.values().length];

    public FlyWeight() {}

    public static Date getDate(Month pMonth, Year pYear) {
        // Use lazy initialization
        if (aFlyWeight[pMonth.ordinal()][pYear.ordinal()] == null) {
            aFlyWeight[pMonth.ordinal()][pYear.ordinal()] = new Date(pMonth, pYear);
        }
        return aFlyWeight[pMonth.ordinal()][pYear.ordinal()];
    }

    public static void main(String[] args) {
        for (Year pYear : Year.values()) {
            for (Month pMonth : Month.values()) {
                System.out.println(getDate(pMonth, pYear));
            }
        }
    }
}
