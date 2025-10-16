package hu.homework.patterns.shapes;

/** Entry point (we'll extend later). */
public final class ShapesApp {
    public static void main(String[] args) {
        System.out.println("Skeleton OK – rectangle demo:");
        AsciiRenderer.rectangle(10, 3, '#', true);
        AsciiRenderer.trapezoid(6, 16, 5, '+', false);
        AsciiRenderer.rhombus(9, '@', true);
        AsciiRenderer.pyramid(6, '*', false, false);
        AsciiRenderer.pyramid(6, '^', true, true);
        AsciiRenderer.ellipse(21, 11, '.', false);

    }
}
