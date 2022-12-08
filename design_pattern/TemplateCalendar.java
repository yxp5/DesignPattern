package design_pattern;

enum AnimalSound {SQUEAK, MOO, MEOW, SNORT, ROAR, HISS, NEIGH, BAA, OUH, POK, WOOF, OINK}

public class TemplateCalendar extends TemplateBlank {

    private final Zodiac aZodiac;

    protected TemplateCalendar(Year pYear, Zodiac pZodiac) {
        super(pYear);
        aZodiac = pZodiac;
    }

    @Override
    public String details() {
        return String.format("Year %s is year of the %s\n", year().name(), aZodiac.name());
    }

    @Override
    public CompositeBase copy() {
        // Just return a new TemplateCalendar since the 2 parameters are enums
        return new TemplateCalendar(year(), aZodiac);
    }

    @Override
    protected String yearQuote() {
        return String.format("%s goes %s", aZodiac.name(), AnimalSound.values()[aZodiac.ordinal()]);
    }

    public static void main(String[] args) {
        TemplateCalendar templateCalendar = new TemplateCalendar(Year.ONE, Zodiac.ROOSTER);
        System.out.println(templateCalendar.details());
        System.out.println(templateCalendar.yearQuote());
    }
}
