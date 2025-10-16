package hu.homework.patterns.shapes.command;

import hu.homework.patterns.shapes.Shape;

/** Concrete Command: wraps any Shape.draw() call. */
public final class DrawShapeCommand implements DrawCommand {
    private final Shape shape;
    public DrawShapeCommand(Shape shape){ this.shape = shape; }
    @Override public void execute() { shape.draw(); }
    @Override public String label() { return "Draw: " + shape.name(); }
}

