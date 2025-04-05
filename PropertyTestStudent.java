

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    @Test
    void testParameterizedConstructor() {
        Property p = new Property("Beach House", "Malibu", 2500.0, "Smith");
        assertEquals("Beach House", p.getPropertyName());
    }

    @Test
    void testCopyConstructor() {
        Property original = new Property("Apartment", "NYC", 3000.0, "Johnson");
        Property copy = new Property(original);
        assertEquals(original.toString(), copy.toString());
    }

    @Test
    void testGetPlot() {
        Property p = new Property("Condo", "Miami", 2000.0, "Lee", 2,3,4,5);
        assertEquals(2, p.getPlot().getX());
    }

    @Test
    void testToString() {
        Property p = new Property("Villa","Rome",1500.0,"Rossi");
        assertEquals("Villa,Rome,Rossi,1500.0", p.toString());
    }
}