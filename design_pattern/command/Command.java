package design_pattern.command;

public interface Command {

    void change(Year pYear);
    void undo();
}
