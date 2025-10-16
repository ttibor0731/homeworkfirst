package hu.homework.patterns.shapes;

import java.util.Arrays;
import java.util.Locale;

/** Entry point: demonstrates patterns and supports CLI drawing. */
public final class ShapesApp {

    private static boolean isOutlineArg(String s){
        if (s == null) return false;
        s = s.toLowerCase(Locale.ROOT);
        return s.contains("outline") || s.equals("o") || s.equals("true");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            // --- Composite + Flyweight demo
            ShapeGroup demo = new ShapeGroup("Composite + Flyweight Demo")
                    .add(new RectangleShape(14, 4, BrushFactory.get('#', true)))
                    .add(new TrapezoidShape(6, 16, 5, BrushFactory.get('+', false)))
                    .add(new RhombusShape(9, BrushFactory.get('@', true)))
                    .add(new PyramidShape(6, false, BrushFactory.get('*', false)))
                    .add(new PyramidShape(6, true,  BrushFactory.get('^', true)))
                    .add(new EllipseShape(21, 11, BrushFactory.get('.', false)));
            System.out.println("Flyweight cache size: " + BrushFactory.cacheSize());
            demo.draw();

            // --- Command demo (Invoker queues draw commands and executes them)
            System.out.println("\n== COMMAND DEMO ==");
            hu.homework.patterns.shapes.command.Invoker invoker =
                    new hu.homework.patterns.shapes.command.Invoker()
                            .add(new hu.homework.patterns.shapes.command.DrawShapeCommand(
                                    new RectangleShape(12, 4, BrushFactory.get('#', true))))
                            .add(new hu.homework.patterns.shapes.command.DrawShapeCommand(
                                    new RhombusShape(9, BrushFactory.get('@', true))))
                            .add(new hu.homework.patterns.shapes.command.DrawShapeCommand(
                                    new EllipseShape(17, 7, BrushFactory.get('.', false))));
            invoker.runAll();

            return;
        }

        // CLI mode
        try {
            String shape = args[0].toLowerCase(Locale.ROOT);
            boolean outline = Arrays.stream(args).anyMatch(ShapesApp::isOutlineArg);

            char ch = '*';
            if (args[args.length - 1].length() == 1) ch = args[args.length - 1].charAt(0);

            switch (shape) {
                case "rectangle":
                case "teglalap": {
                    int w = Integer.parseInt(args[1]);
                    int h = Integer.parseInt(args[2]);
                    AsciiRenderer.rectangle(w, h, ch, outline);
                    break;
                }
                case "trapezoid":
                case "trapez": {
                    int top = Integer.parseInt(args[1]);
                    int bottom = Integer.parseInt(args[2]);
                    int hh = Integer.parseInt(args[3]);
                    AsciiRenderer.trapezoid(top, bottom, hh, ch, outline);
                    break;
                }
                case "rhombus":
                case "rombusz": {
                    int d = Integer.parseInt(args[1]);
                    AsciiRenderer.rhombus(d, ch, outline);
                    break;
                }
                case "pyramid":
                case "piramis": {
                    int hh = Integer.parseInt(args[1]);
                    boolean inv = Arrays.stream(args)
                            .anyMatch(a -> a.equalsIgnoreCase("inverted") || a.contains("lefele"));
                    AsciiRenderer.pyramid(hh, ch, inv, outline);
                    break;
                }
                case "ellipse":
                case "ellipszis":
                case "elipszis": {
                    int w = Integer.parseInt(args[1]);
                    int h = Integer.parseInt(args[2]);
                    AsciiRenderer.ellipse(w, h, ch, outline);
                    break;
                }
                default:
                    System.err.println("Unknown shape: " + shape);
            }
        } catch (Exception e){
            System.err.println("Invalid parameters: " + e.getMessage());
            System.err.println("Examples:");
            System.err.println("  java hu.homework.patterns.shapes.ShapesApp rectangle 12 4 # outline");
            System.err.println("  java hu.homework.patterns.shapes.ShapesApp trapez 6 16 5 +");
            System.err.println("  java hu.homework.patterns.shapes.ShapesApp rombusz 9 @ outline");
            System.err.println("  java hu.homework.patterns.shapes.ShapesApp piramis 7 * inverted outline");
            System.err.println("  java hu.homework.patterns.shapes.ShapesApp ellipszis 21 11 .");
        }
    }
}
