package hu.homework.patterns.shapes;
public final class RhombusShape implements Shape {
    final int diag; final Brush b;
    public RhombusShape(int diag, Brush b){ this.diag=diag; this.b=b; }
    @Override public String name(){ return "Rhombus d=" + diag + " " + b; }
    @Override public void draw(){ AsciiRenderer.rhombus(diag, b.fillChar, b.outline); }
}

