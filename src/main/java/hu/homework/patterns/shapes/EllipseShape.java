package hu.homework.patterns.shapes;
public final class EllipseShape implements Shape {
    final int w,h; final Brush b;
    public EllipseShape(int w, int h, Brush b){ this.w=w; this.h=h; this.b=b; }
    @Override public String name(){ return "Ellipse " + w + "x" + h + " " + b; }
    @Override public void draw(){ AsciiRenderer.ellipse(w, h, b.fillChar, b.outline); }
}

