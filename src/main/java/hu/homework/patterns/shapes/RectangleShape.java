package hu.homework.patterns.shapes;
public final class RectangleShape implements Shape {
    final int w, h; final Brush b;
    public RectangleShape(int w, int h, Brush b){ this.w=w; this.h=h; this.b=b; }
    @Override public String name(){ return "Rectangle " + w + "x" + h + " " + b; }
    @Override public void draw(){ AsciiRenderer.rectangle(w, h, b.fillChar, b.outline); }
}

