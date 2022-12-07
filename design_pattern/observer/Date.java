package design_pattern.observer;

public class Date implements Observer {

    private final Month aMonth;
    private Year aYear;

    public Date(Month pMonth, Year pYear) {
        assert pMonth != null && pYear != null;
        aMonth = pMonth;
        aYear = pYear;
    }

    public boolean sameMonthAs(Month pMonth) {
        assert pMonth != null;
        return aMonth == pMonth;
    }

    @Override
    public Year year() {
        return aYear;
    }

    public boolean equals(Object pObject) {
        if (pObject == null) {
            return false;
        } else if (pObject == this) {
            return true;
        } else if (pObject.getClass() != this.getClass()) {
            return false;
        } else {
            return this.aMonth == ((Date)pObject).aMonth && this.aYear == ((Date)pObject).aYear;
        }
    }

    @Override
    public String toString() {
        return aMonth + " of year " + aYear;
    }

    // Push data-flow
    @Override
    public void newYear(Year pYear) {
        // data pYear is pushed into this.aYear
        aYear = pYear;
    }

    // Pull data-flow
    @Override
    public void newYear(CalendarBase pBase) {
        // Pulling data of Year from pBase
        aYear = pBase.year();
    }
}
