

/**
 * Represents a plot of land with geometric properties
 */
/**
 * Represents a plot of land with coordinates and dimensions
 */
public class Plot {
    private int x, y, width, depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot other) {
        this(other.x, other.y, other.width, other.depth);
    }

    public boolean overlaps(Plot other) {
        return (x < other.x + other.width) && (x + width > other.x) &&
               (y < other.y + other.depth) && (y + depth > other.y);
    }

    public boolean encompasses(Plot other) {
        return (other.x >= x) && (other.x + other.width <= x + width) &&
               (other.y >= y) && (other.y + other.depth <= y + depth);
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}