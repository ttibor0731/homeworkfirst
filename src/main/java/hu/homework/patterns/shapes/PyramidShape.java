package hu.homework.patterns.shapes;
public final class PyramidShape implements Shape {
    final int h; final boolean inverted; final Brush b;
    public PyramidShape(int h, boolean inverted, Brush b){ this.h=h; this.inverted=inverted; this.b=b; }
    @Override public String name(){ return (inverted ? "Inverted " : "") + "Pyramid h=" + h + " " + b; }
    @Override public void draw(){ AsciiRenderer.pyramid(h, b.fillChar, inverted, b.outline); }
}

