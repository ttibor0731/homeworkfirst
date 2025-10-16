package hu.homework.patterns.shapes.command;

/** Command pattern: encapsulates a draw action. */
public interface DrawCommand {
    void execute();
    String label();
}

