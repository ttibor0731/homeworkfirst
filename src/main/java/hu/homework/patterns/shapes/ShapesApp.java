package hu.homework.patterns.shapes;

/** Entry point (we'll extend later). */
public final class ShapesApp {
    public static void main(String[] args) {

        // --- Flyweight optional test: should print cache size 1 and 'same? true'
        Brush b1 = BrushFactory.get('*', false);
        Brush b2 = BrushFactory.get('*', false);
        System.out.println("Flyweight cache: " + BrushFactory.cacheSize() +
                " same? " + (b1 == b2));

        System.out.println("Skeleton OK – rectangle demo:");
        AsciiRenderer.rectangle(10, 3, '#', true);
        AsciiRenderer.trapezoid(6, 16, 5, '+', false);
        AsciiRenderer.rhombus(9, '@', true);
        AsciiRenderer.pyramid(6, '*', false, false);
        AsciiRenderer.pyramid(6, '^', true, true);
        AsciiRenderer.ellipse(21, 11, '.', false);

        // --- 4.3 Composite + Flyweight demo: use concrete shape classes
        ShapeGroup demo = new ShapeGroup("Composite + Flyweight Demo")
                .add(new RectangleShape(14, 4, BrushFactory.get('#', true)))
                .add(new TrapezoidShape(6, 16, 5, BrushFactory.get('+', false)))
                .add(new RhombusShape(9, BrushFactory.get('@', true)))
                .add(new PyramidShape(6, false, BrushFactory.get('*', false)))
                .add(new PyramidShape(6, true,  BrushFactory.get('^', true)))
                .add(new EllipseShape(21, 11, BrushFactory.get('.', false)));

        demo.draw();
    }
}

