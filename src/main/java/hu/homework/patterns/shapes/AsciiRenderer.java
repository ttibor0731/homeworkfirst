package hu.homework.patterns.shapes;

/** Static drawing routines used by the concrete shapes. */
public final class AsciiRenderer {
    private AsciiRenderer() {}

    /** Rectangle. */
    public static void rectangle(int width, int height, char c, boolean outline) {
        if (width < 1 || height < 1) return;
        for (int y=0; y<height; y++){
            StringBuilder row = new StringBuilder();
            for (int x=0; x<width; x++){
                if (!outline || y==0 || y==height-1 || x==0 || x==width-1) row.append(c);
                else row.append(' ');
            }
            System.out.println(row);
        }
    }
}
