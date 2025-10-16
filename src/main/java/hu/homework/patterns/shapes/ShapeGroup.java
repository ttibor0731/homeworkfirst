package hu.homework.patterns.shapes;

import java.util.ArrayList;
import java.util.List;

/** Composite: group of shapes treated as a single shape. */
public final class ShapeGroup implements Shape {
    private final String name;
    private final List<Shape> children = new ArrayList<>();
    public ShapeGroup(String name) { this.name = name; }
    public ShapeGroup add(Shape s) { children.add(s); return this; }
    @Override public String name() { return name; }
    @Override public void draw() {
        System.out.println("== " + name + " ==");
        for (Shape s : children) {
            System.out.println("-- " + s.name() + " --");
            s.draw();
            System.out.println();
        }
    }
}

