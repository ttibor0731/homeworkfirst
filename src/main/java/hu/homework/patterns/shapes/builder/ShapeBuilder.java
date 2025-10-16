package hu.homework.patterns.shapes.builder;

import hu.homework.patterns.shapes.*;
import java.util.ArrayList;
import java.util.List;

/** Builder pattern: fluent builder to assemble multiple shapes into a ShapeGroup safely. */
public final class ShapeBuilder {
    private final List<Shape> items = new ArrayList<>();
    private final String groupName;
    private Brush defaultBrush = BrushFactory.get('*', false);

    public ShapeBuilder(String groupName) { this.groupName = groupName; }

    public ShapeBuilder withDefaultBrush(char c, boolean outline) {
        this.defaultBrush = BrushFactory.get(c, outline);
        return this;
    }

    public ShapeBuilder rectangle(int w, int h, Brush b){ items.add(new RectangleShape(w, h, b)); return this; }
    public ShapeBuilder rectangle(int w, int h){ return rectangle(w, h, defaultBrush); }

    public ShapeBuilder trapezoid(int top, int bottom, int h, Brush b){ items.add(new TrapezoidShape(top, bottom, h, b)); return this; }
    public ShapeBuilder trapezoid(int top, int bottom, int h){ return trapezoid(top, bottom, h, defaultBrush); }

    public ShapeBuilder rhombus(int diag, Brush b){ items.add(new RhombusShape(diag, b)); return this; }
    public ShapeBuilder rhombus(int diag){ return rhombus(diag, defaultBrush); }

    public ShapeBuilder pyramid(int h, boolean inverted, Brush b){ items.add(new PyramidShape(h, inverted, b)); return this; }
    public ShapeBuilder pyramid(int h, boolean inverted){ return pyramid(h, inverted, defaultBrush); }

    public ShapeBuilder ellipse(int w, int h, Brush b){ items.add(new EllipseShape(w, h, b)); return this; }
    public ShapeBuilder ellipse(int w, int h){ return ellipse(w, h, defaultBrush); }

    public ShapeGroup build(){
        ShapeGroup group = new ShapeGroup(groupName);
        for (Shape s : items) group.add(s);
        return group;
    }
}

