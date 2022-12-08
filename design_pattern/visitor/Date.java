package design_pattern.visitor;

public class Date {

    private final Month aMonth;
    private final Year aYear;

    public Date(Month pMonth, Year pYear) {
        assert pMonth != null && pYear != null;
        aMonth = pMonth;
        aYear = pYear;
    }

    public boolean sameMonthAs(Month pMonth) {
        assert pMonth != null;
        return aMonth == pMonth;
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
}
