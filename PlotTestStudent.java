
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

    @Test
    void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    void testCopyConstructor() {
        Plot original = new Plot(1, 2, 3, 4);
        Plot copy = new Plot(original);
        assertEquals(original.getX(), copy.getX());
        assertEquals(original.getDepth(), copy.getDepth());
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 2, 2);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    void testEncompasses() {
        Plot large = new Plot(0, 0, 5, 5);
        Plot small = new Plot(1, 1, 2, 2);
        assertTrue(large.encompasses(small));
    }

    @Test
    void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", plot.toString());
    }
}