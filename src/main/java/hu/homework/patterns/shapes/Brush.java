package hu.homework.patterns.shapes;

/** Flyweight: value object for drawing character + outline/solid flag. */
public final class Brush {
    public final char fillChar;
    public final boolean outline;
    Brush(char fillChar, boolean outline) {
        this.fillChar = fillChar;
        this.outline = outline;
    }
    @Override public String toString() {
        return "Brush[" + fillChar + (outline ? ", outline" : ", solid") + "]";
    }
}
