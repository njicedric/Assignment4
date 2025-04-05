
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

    @Test
    void testAddProperty() {
        ManagementCompany mgmt = new ManagementCompany("ABC", "123", 10);
        Property p = new Property("House", "Rockville", 2000.0, "Smith", 1,1,2,2);
        assertEquals(0, mgmt.addProperty(p));
    }

    @Test
    void testGetTotalRent() {
        ManagementCompany mgmt = new ManagementCompany();
        mgmt.addProperty(new Property("A", "B", 1000.0, "C"));
        mgmt.addProperty(new Property("D", "E", 2000.0, "F"));
        assertEquals(3000.0, mgmt.getTotalRent(), 0.001);
    }

    @Test
    void testGetHighestRentProperty() {
        ManagementCompany mgmt = new ManagementCompany();
        Property p1 = new Property("Cheap", "Town", 500.0, "Owner1");
        Property p2 = new Property("Expensive", "City", 5000.0, "Owner2");
        mgmt.addProperty(p1);
        mgmt.addProperty(p2);
        assertEquals(p2, mgmt.getHighestRentProperty());
    }

    @Test
    void testToString() {
        ManagementCompany mgmt = new ManagementCompany("XYZ", "456", 5);
        mgmt.addProperty(new Property("Beach", "Ocean", 3000.0, "Surfer"));
        String output = mgmt.toString();
        assertTrue(output.contains("Beach,Ocean,Surfer,3000.0"));
    }
}