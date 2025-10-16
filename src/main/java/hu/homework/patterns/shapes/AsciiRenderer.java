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

    /** Trapezoid – centered; linearly interpolates width from topWidth to bottomWidth. */
    public static void trapezoid(int topWidth, int bottomWidth, int height, char c, boolean outline){
        if (height < 1 || topWidth < 1 || bottomWidth < 1) return;
        int max = Math.max(topWidth, bottomWidth);
        for (int y=0; y<height; y++){
            double t = (height==1) ? 0.0 : (y/(double)(height-1));
            int w = (int)Math.round(topWidth*(1-t) + bottomWidth*t);
            int pad = (max - w)/2;
            StringBuilder row = new StringBuilder();
            for (int i=0;i<pad;i++) row.append(' ');
            for (int x=0;x<w;x++){
                if (!outline || y==0 || y==height-1 || x==0 || x==w-1) row.append(c);
                else row.append(' ');
            }
            System.out.println(row);
        }
    }

    /** Rhombus – odd diagonal length; even values bumped to next odd for nicer look. */
    public static void rhombus(int diag, char c, boolean outline){
        if (diag < 1) return;
        if (diag % 2 == 0) diag += 1;
        int mid = diag/2;
        for (int y=0; y<diag; y++){
            int dist = Math.abs(mid - y);
            int w = diag - 2*dist;
            int pad = dist;
            StringBuilder row = new StringBuilder();
            for (int i=0;i<pad;i++) row.append(' ');
            for (int x=0;x<w;x++){
                boolean border = (x==0 || x==w-1 || y==0 || y==diag-1);
                row.append((!outline || border) ? c : ' ');
            }
            System.out.println(row);
        }
    }

    /** Pyramid – inverted=false normal, inverted=true upside-down. */
    public static void pyramid(int height, char c, boolean inverted, boolean outline){
        if (height < 1) return;
        int levels = height;
        for (int i=0;i<levels;i++){
            int level = inverted ? (levels-1 - i) : i;
            int w = 2*level + 1;
            int pad = (2*levels - 1 - w)/2;
            StringBuilder row = new StringBuilder();
            for (int s=0;s<pad;s++) row.append(' ');
            for (int x=0;x<w;x++){
                boolean border = (level==0 || level==levels-1 || x==0 || x==w-1);
                row.append((!outline || border) ? c : ' ');
            }
            System.out.println(row);
        }
    }

    /** Ellipse – rasterized by x^2/a^2 + y^2/b^2 <= 1; outline draws around 1 with tolerance. */
    public static void ellipse(int w, int h, char c, boolean outline){
        if (w < 2 || h < 2) { rectangle(Math.max(w,1), Math.max(h,1), c, outline); return; }
        double a = (w-1)/2.0, b = (h-1)/2.0;
        double cx = a, cy = b;
        double eps = 0.5; // tolerance for outline

        for (int y=0; y<h; y++){
            StringBuilder row = new StringBuilder();
            for (int x=0; x<w; x++){
                double nx = (x - cx)/a, ny = (y - cy)/b;
                double val = nx*nx + ny*ny;
                boolean inside = val <= 1.0;
                if (!outline) row.append(inside ? c : ' ');
                else row.append(Math.abs(val - 1.0) <= (1.0/a + 1.0/b) * eps ? c : ' ');
            }
            System.out.println(row);
        }
    }
}

