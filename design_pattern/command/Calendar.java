package design_pattern.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calendar {

    private final List<Date> aMonths = new ArrayList<>();
    private Year aYear;

    public Calendar(Year pYear) {
        initialize(pYear);
    }

    private void initialize(Year pYear) {
        assert pYear != null;
        for (Month aMonth : Month.values()) {
            aMonths.add(new Date(aMonth, pYear));
        }
        aYear = pYear;
    }

    public Year year() {
        return aYear;
    }

    public List<Date> months() {
        return Collections.unmodifiableList(aMonths);
    }

    public Command changeYearCommand() {
        return new Command() {
            private final Stack<Year> aMemory = new Stack<Year>();

            @Override
            public void change(Year pYear) {
                aMemory.push(aYear);
                initialize(pYear);
            }

            @Override
            public void undo() {
                if (!aMemory.isEmpty()) {
                    Year pYear = aMemory.pop();
                    initialize(pYear);
                } else {
                    System.out.println("This is the last command! Can not go back any further.\n");
                }
            }
        };
    }

    @Override
    public String toString() {
        return "Year " + aYear.name() + "\n";
    }

    public static void main(String[] args) {
        // Testing command correctness
        Calendar calendar = new Calendar(Year.ONE);
        Command command = calendar.changeYearCommand();
        System.out.println(calendar);

        command.change(Year.TWO);
        System.out.println(calendar);

        command.change(Year.NINE);
        System.out.println(calendar);

        command.change(Year.TEN);
        command.change(Year.SIX);
        System.out.println(calendar);

        command.undo();
        System.out.println(calendar);

        command.undo();
        command.undo();
        command.undo();
        System.out.println(calendar);

        command.undo();
    }
}
