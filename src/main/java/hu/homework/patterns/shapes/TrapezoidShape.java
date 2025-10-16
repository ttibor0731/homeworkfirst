package hu.homework.patterns.shapes;
public final class TrapezoidShape implements Shape {
    final int top, bottom, h; final Brush b;
    public TrapezoidShape(int top, int bottom, int h, Brush b){ this.top=top; this.bottom=bottom; this.h=h; this.b=b; }
    @Override public String name(){ return "Trapezoid top=" + top + " bottom=" + bottom + " h=" + h + " " + b; }
    @Override public void draw(){ AsciiRenderer.trapezoid(top, bottom, h, b.fillChar, b.outline); }
}

